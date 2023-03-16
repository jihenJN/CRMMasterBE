import dayjs from 'dayjs/esm';
import { IClient } from 'app/entities/client/client.model';

export interface IInvoice {
  id: string;
  discount?: number | null;
  tax?: number | null;
  date?: dayjs.Dayjs | null;
  total?: number | null;
  stamp?: number | null;
  remarks?: string | null;
  client?: Pick<IClient, 'id'> | null;
}

export type NewInvoice = Omit<IInvoice, 'id'> & { id: null };
