import { ISale, NewSale } from './sale.model';

export const sampleWithRequiredData: ISale = {
  id: 'e3d390cb-6ca7-40d1-872d-cd036a294d97',
};

export const sampleWithPartialData: ISale = {
  id: '0e7b3e40-8d53-4bf5-af2f-0387d03b6227',
  quantity: 11839,
  price: 96402,
  tax: 11392,
};

export const sampleWithFullData: ISale = {
  id: '0d6304c9-00a0-446c-a8a7-7233f80c06ea',
  quantity: 75072,
  price: 82485,
  tax: 10854,
  discount: 69353,
  available: false,
};

export const sampleWithNewData: NewSale = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
