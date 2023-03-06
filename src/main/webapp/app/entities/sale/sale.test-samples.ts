import { ISale, NewSale } from './sale.model';

export const sampleWithRequiredData: ISale = {
  id: 'e3d390cb-6ca7-40d1-872d-cd036a294d97',
};

export const sampleWithPartialData: ISale = {
  id: 'a8640e7b-3e40-48d5-bbf5-2f2f0387d03b',
  quantity: 42411,
};

export const sampleWithFullData: ISale = {
  id: '2271f10d-6304-4c90-8a04-6c68a77233f8',
  quantity: 1694,
};

export const sampleWithNewData: NewSale = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
