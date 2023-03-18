import dayjs from 'dayjs/esm';

import { IInvoice, NewInvoice } from './invoice.model';

export const sampleWithRequiredData: IInvoice = {
  id: 'e9811367-3777-4285-ab8f-e916c058e54f',
  code: 'card Chicken',
};

export const sampleWithPartialData: IInvoice = {
  id: 'fde13186-e041-4cf8-b9c7-8bc7ad4f9872',
  tax: 49829,
  total: 5549,
  remarks: 'Bond Industrial',
  code: 'synthesize',
};

export const sampleWithFullData: IInvoice = {
  id: '48cf88a0-2ac5-4036-9410-6258c3fa9212',
  discount: 74504,
  tax: 89737,
  date: dayjs('2023-03-06T11:52'),
  total: 13398,
  stamp: 1710,
  remarks: 'throughput Intelligent deposit',
  code: 'Programmable transform Parkway',
};

export const sampleWithNewData: NewInvoice = {
  code: 'user Representative Rand',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
