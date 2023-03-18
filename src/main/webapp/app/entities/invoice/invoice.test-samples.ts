import dayjs from 'dayjs/esm';

import { IInvoice, NewInvoice } from './invoice.model';

export const sampleWithRequiredData: IInvoice = {
  id: 'e9811367-3777-4285-ab8f-e916c058e54f',
  code: 'card Chicken',
};

export const sampleWithPartialData: IInvoice = {
  id: 'fde13186-e041-4cf8-b9c7-8bc7ad4f9872',
  code: 'Practical Industrial',
  discount: 7945,
  total: 77441,
  remarks: 'black parse Nigeria',
};

export const sampleWithFullData: IInvoice = {
  id: '2ac5036d-4106-4258-83fa-9212be220d5f',
  code: 'Intelligent deposit',
  date: dayjs('2023-03-05T19:14'),
  discount: 23255,
  tax: 66487,
  total: 18397,
  stamp: '../fake-data/blob/hipster.png',
  stampContentType: 'unknown',
  remarks: 'Soft York',
};

export const sampleWithNewData: NewInvoice = {
  code: 'Jamahiriya',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
