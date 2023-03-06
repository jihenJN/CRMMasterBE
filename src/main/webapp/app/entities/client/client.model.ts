export interface IClient {
  id: string;
  name?: string | null;
  phone?: number | null;
  address?: string | null;
  email?: string | null;
  orders?: number | null;
  fidelityCard?: boolean | null;
}

export type NewClient = Omit<IClient, 'id'> & { id: null };
