import dayjs from 'dayjs/esm';
import { IClient } from 'app/entities/client/client.model';
import { status } from 'app/entities/enumerations/status.model';

export interface IInvoice {
  id: string;
  code?: string | null;
  date?: dayjs.Dayjs | null;
  discount?: number | null;
  tax?: number | null;
  total?: number | null;
  stamp?: string | null;
  stampContentType?: string | null;
  remarks?: string | null;
  status?: status | null;
  client?: Pick<IClient, 'id' | 'name'> | null;
}

export type NewInvoice = Omit<IInvoice, 'id'> & { id: null };
