import { IProduct } from 'app/entities/product/product.model';
import { IInvoice } from 'app/entities/invoice/invoice.model';

export interface ISale {
  id: string;
  quantity?: number | null;
  price?: number | null;
  tax?: number | null;
  discount?: number | null;
  product?: Pick<IProduct, 'id' | 'name'> | null;
  invoice?: Pick<IInvoice, 'id'> | null;
}

export type NewSale = Omit<ISale, 'id'> & { id: null };
