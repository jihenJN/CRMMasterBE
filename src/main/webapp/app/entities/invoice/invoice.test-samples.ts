import dayjs from 'dayjs/esm';

import { status } from 'app/entities/enumerations/status.model';

import { IInvoice, NewInvoice } from './invoice.model';

export const sampleWithRequiredData: IInvoice = {
  id: 'e9811367-3777-4285-ab8f-e916c058e54f',
  code: 'card Chicken',
};

export const sampleWithPartialData: IInvoice = {
  id: 'de13186e-041c-4f83-9c78-bc7ad4f98727',
  code: 'Ranch',
  discount: 10715,
  total: 2448,
  remarks: 'optimize Cuban Samoa',
  status: status['PAID'],
};

export const sampleWithFullData: IInvoice = {
  id: '8a02ac50-36d4-4106-a58c-3fa9212be220',
  code: 'throughput Intelligent deposit',
  date: dayjs('2023-03-05T19:14'),
  discount: 23255,
  tax: 66487,
  total: 18397,
  stamp: '../fake-data/blob/hipster.png',
  stampContentType: 'unknown',
  remarks: 'Soft York',
  status: status['RECEIVED'],
};

export const sampleWithNewData: NewInvoice = {
  code: 'Cambridgeshire olive',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
