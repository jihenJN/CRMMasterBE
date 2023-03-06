import dayjs from 'dayjs/esm';
import { IClient } from 'app/entities/client/client.model';

export interface IInvoice {
  id: string;
  discount?: number | null;
  tax?: number | null;
  stamp?: string | null;
  stampContentType?: string | null;
  date?: dayjs.Dayjs | null;
  total?: number | null;
  client?: Pick<IClient, 'id'> | null;
}

export type NewInvoice = Omit<IInvoice, 'id'> & { id: null };
