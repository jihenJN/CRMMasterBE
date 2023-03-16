import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { SaleFormService } from './sale-form.service';
import { SaleService } from '../service/sale.service';
import { ISale } from '../sale.model';
import { IProduct } from 'app/entities/product/product.model';
import { ProductService } from 'app/entities/product/service/product.service';
import { IInvoice } from 'app/entities/invoice/invoice.model';
import { InvoiceService } from 'app/entities/invoice/service/invoice.service';

import { SaleUpdateComponent } from './sale-update.component';

describe('Sale Management Update Component', () => {
  let comp: SaleUpdateComponent;
  let fixture: ComponentFixture<SaleUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let saleFormService: SaleFormService;
  let saleService: SaleService;
  let productService: ProductService;
  let invoiceService: InvoiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([])],
      declarations: [SaleUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(SaleUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(SaleUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    saleFormService = TestBed.inject(SaleFormService);
    saleService = TestBed.inject(SaleService);
    productService = TestBed.inject(ProductService);
    invoiceService = TestBed.inject(InvoiceService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call Product query and add missing value', () => {
      const sale: ISale = { id: 'CBA' };
      const product: IProduct = { id: 'b8e32048-c476-4abe-b892-79f973f89ccd' };
      sale.product = product;

      const productCollection: IProduct[] = [{ id: '146f6b13-fb8e-4b9c-8eca-a41f9639d3aa' }];
      jest.spyOn(productService, 'query').mockReturnValue(of(new HttpResponse({ body: productCollection })));
      const additionalProducts = [product];
      const expectedCollection: IProduct[] = [...additionalProducts, ...productCollection];
      jest.spyOn(productService, 'addProductToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ sale });
      comp.ngOnInit();

      expect(productService.query).toHaveBeenCalled();
      expect(productService.addProductToCollectionIfMissing).toHaveBeenCalledWith(
        productCollection,
        ...additionalProducts.map(expect.objectContaining)
      );
      expect(comp.productsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Invoice query and add missing value', () => {
      const sale: ISale = { id: 'CBA' };
      const invoice: IInvoice = { id: '8f856556-39d1-4747-8ba2-3e6cb19f0b07' };
      sale.invoice = invoice;

      const invoiceCollection: IInvoice[] = [{ id: 'f91ae246-0621-4900-9d5b-6938e19b08ad' }];
      jest.spyOn(invoiceService, 'query').mockReturnValue(of(new HttpResponse({ body: invoiceCollection })));
      const additionalInvoices = [invoice];
      const expectedCollection: IInvoice[] = [...additionalInvoices, ...invoiceCollection];
      jest.spyOn(invoiceService, 'addInvoiceToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ sale });
      comp.ngOnInit();

      expect(invoiceService.query).toHaveBeenCalled();
      expect(invoiceService.addInvoiceToCollectionIfMissing).toHaveBeenCalledWith(
        invoiceCollection,
        ...additionalInvoices.map(expect.objectContaining)
      );
      expect(comp.invoicesSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const sale: ISale = { id: 'CBA' };
      const product: IProduct = { id: 'deeb8fa3-f389-468d-a351-d8a520693237' };
      sale.product = product;
      const invoice: IInvoice = { id: '19aad749-aee5-402c-9fee-473c2b37739a' };
      sale.invoice = invoice;

      activatedRoute.data = of({ sale });
      comp.ngOnInit();

      expect(comp.productsSharedCollection).toContain(product);
      expect(comp.invoicesSharedCollection).toContain(invoice);
      expect(comp.sale).toEqual(sale);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<ISale>>();
      const sale = { id: 'ABC' };
      jest.spyOn(saleFormService, 'getSale').mockReturnValue(sale);
      jest.spyOn(saleService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ sale });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: sale }));
      saveSubject.complete();

      // THEN
      expect(saleFormService.getSale).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(saleService.update).toHaveBeenCalledWith(expect.objectContaining(sale));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<ISale>>();
      const sale = { id: 'ABC' };
      jest.spyOn(saleFormService, 'getSale').mockReturnValue({ id: null });
      jest.spyOn(saleService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ sale: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: sale }));
      saveSubject.complete();

      // THEN
      expect(saleFormService.getSale).toHaveBeenCalled();
      expect(saleService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<ISale>>();
      const sale = { id: 'ABC' };
      jest.spyOn(saleService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ sale });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(saleService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('compareProduct', () => {
      it('Should forward to productService', () => {
        const entity = { id: 'ABC' };
        const entity2 = { id: 'CBA' };
        jest.spyOn(productService, 'compareProduct');
        comp.compareProduct(entity, entity2);
        expect(productService.compareProduct).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareInvoice', () => {
      it('Should forward to invoiceService', () => {
        const entity = { id: 'ABC' };
        const entity2 = { id: 'CBA' };
        jest.spyOn(invoiceService, 'compareInvoice');
        comp.compareInvoice(entity, entity2);
        expect(invoiceService.compareInvoice).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});
