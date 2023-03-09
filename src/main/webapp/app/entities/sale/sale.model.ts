import { IInvoice } from 'app/entities/invoice/invoice.model';
import { IProduct } from 'app/entities/product/product.model';

export interface ISale {
  id: string;
  quantity?: number | null;
  price?: number | null;
  tax?: number | null;
  discount?: number | null;
  invoice?: Pick<IInvoice, 'id'> | null;
  product?: Pick<IProduct, 'id' | 'name'> | null;
}

export type NewSale = Omit<ISale, 'id'> & { id: null };
