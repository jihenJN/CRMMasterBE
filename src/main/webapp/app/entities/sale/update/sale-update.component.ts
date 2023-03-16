import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { SaleFormService, SaleFormGroup } from './sale-form.service';
import { ISale } from '../sale.model';
import { SaleService } from '../service/sale.service';
import { IProduct } from 'app/entities/product/product.model';
import { ProductService } from 'app/entities/product/service/product.service';
import { IInvoice } from 'app/entities/invoice/invoice.model';
import { InvoiceService } from 'app/entities/invoice/service/invoice.service';

@Component({
  selector: 'jhi-sale-update',
  templateUrl: './sale-update.component.html',
})
export class SaleUpdateComponent implements OnInit {
  isSaving = false;
  sale: ISale | null = null;

  productsSharedCollection: IProduct[] = [];
  invoicesSharedCollection: IInvoice[] = [];

  editForm: SaleFormGroup = this.saleFormService.createSaleFormGroup();

  constructor(
    protected saleService: SaleService,
    protected saleFormService: SaleFormService,
    protected productService: ProductService,
    protected invoiceService: InvoiceService,
    protected activatedRoute: ActivatedRoute
  ) {}

  compareProduct = (o1: IProduct | null, o2: IProduct | null): boolean => this.productService.compareProduct(o1, o2);

  compareInvoice = (o1: IInvoice | null, o2: IInvoice | null): boolean => this.invoiceService.compareInvoice(o1, o2);

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ sale }) => {
      this.sale = sale;
      if (sale) {
        this.updateForm(sale);
      }

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const sale = this.saleFormService.getSale(this.editForm);
    if (sale.id !== null) {
      this.subscribeToSaveResponse(this.saleService.update(sale));
    } else {
      this.subscribeToSaveResponse(this.saleService.create(sale));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ISale>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(sale: ISale): void {
    this.sale = sale;
    this.saleFormService.resetForm(this.editForm, sale);

    this.productsSharedCollection = this.productService.addProductToCollectionIfMissing<IProduct>(
      this.productsSharedCollection,
      sale.product
    );
    this.invoicesSharedCollection = this.invoiceService.addInvoiceToCollectionIfMissing<IInvoice>(
      this.invoicesSharedCollection,
      sale.invoice
    );
  }

  protected loadRelationshipsOptions(): void {
    this.productService
      .query()
      .pipe(map((res: HttpResponse<IProduct[]>) => res.body ?? []))
      .pipe(map((products: IProduct[]) => this.productService.addProductToCollectionIfMissing<IProduct>(products, this.sale?.product)))
      .subscribe((products: IProduct[]) => (this.productsSharedCollection = products));

    this.invoiceService
      .query()
      .pipe(map((res: HttpResponse<IInvoice[]>) => res.body ?? []))
      .pipe(map((invoices: IInvoice[]) => this.invoiceService.addInvoiceToCollectionIfMissing<IInvoice>(invoices, this.sale?.invoice)))
      .subscribe((invoices: IInvoice[]) => (this.invoicesSharedCollection = invoices));
  }
}
