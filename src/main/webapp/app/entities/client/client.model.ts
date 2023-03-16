export interface IClient {
  id: string;
  name?: string | null;
  phone?: number | null;
  address?: string | null;
  email?: string | null;
}

export type NewClient = Omit<IClient, 'id'> & { id: null };
