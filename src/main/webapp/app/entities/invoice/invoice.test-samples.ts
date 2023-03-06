import dayjs from 'dayjs/esm';

import { IInvoice, NewInvoice } from './invoice.model';

export const sampleWithRequiredData: IInvoice = {
  id: 'e9811367-3777-4285-ab8f-e916c058e54f',
};

export const sampleWithPartialData: IInvoice = {
  id: 'b2292c5e-fde1-4318-ae04-1cf839c78bc7',
  discount: 63711,
  tax: 81783,
  date: dayjs('2023-03-06T09:47'),
};

export const sampleWithFullData: IInvoice = {
  id: 'f9872707-ae10-4f51-8a24-8cf88a02ac50',
  discount: 22387,
  tax: 42002,
  stamp: '../fake-data/blob/hipster.png',
  stampContentType: 'unknown',
  date: dayjs('2023-03-05T19:49'),
  total: 30400,
};

export const sampleWithNewData: NewInvoice = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
