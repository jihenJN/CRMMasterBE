import { ISale, NewSale } from './sale.model';

export const sampleWithRequiredData: ISale = {
  id: 'e3d390cb-6ca7-40d1-872d-cd036a294d97',
};

export const sampleWithPartialData: ISale = {
  id: '40e7b3e4-08d5-43bf-92f2-f0387d03b622',
  quantity: 49939,
  price: 11839,
  tax: 96402,
};

export const sampleWithFullData: ISale = {
  id: '10d6304c-900a-4046-868a-77233f80c06e',
  quantity: 63521,
  price: 75072,
  tax: 82485,
  discount: 10854,
};

export const sampleWithNewData: NewSale = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
