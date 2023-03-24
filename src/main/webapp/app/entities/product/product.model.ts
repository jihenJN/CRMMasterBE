export interface IProduct {
  id: string;
  name?: string | null;
  price?: number | null;
  photo?: string | null;
  photoContentType?: string | null;
  description?: string | null;
  tax?: number | null;
  inStock?: number | null;
}

export type NewProduct = Omit<IProduct, 'id'> & { id: null };
