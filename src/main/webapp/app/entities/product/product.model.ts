export interface IProduct {
  id: string;
  name?: string | null;
  price?: number | null;
  photo?: string | null;
  photoContentType?: string | null;
  favorite?: boolean | null;
  description?: string | null;
  stars?: number | null;
  supplier?: string | null;
}

export type NewProduct = Omit<IProduct, 'id'> & { id: null };
