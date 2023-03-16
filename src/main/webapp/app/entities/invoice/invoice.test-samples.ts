import dayjs from 'dayjs/esm';

import { IInvoice, NewInvoice } from './invoice.model';

export const sampleWithRequiredData: IInvoice = {
  id: 'e9811367-3777-4285-ab8f-e916c058e54f',
};

export const sampleWithPartialData: IInvoice = {
  id: '2292c5ef-de13-4186-a041-cf839c78bc7a',
  discount: 81783,
  tax: 27330,
  total: 98624,
  remarks: 'Liberia Avon',
};

export const sampleWithFullData: IInvoice = {
  id: 'ae10f51c-a248-4cf8-8a02-ac5036d41062',
  discount: 32313,
  tax: 55461,
  date: dayjs('2023-03-05T21:05'),
  total: 21973,
  stamp: 99850,
  remarks: 'Savings Soft purple',
};

export const sampleWithNewData: NewInvoice = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
