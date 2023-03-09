import { IProduct, NewProduct } from './product.model';

export const sampleWithRequiredData: IProduct = {
  id: 'c442dfc5-f1e3-4a23-b568-16f6b07dcadc',
};

export const sampleWithPartialData: IProduct = {
  id: '5732e9cd-2531-453f-a3a4-5b5084beccd5',
  name: 'Tuna Marketing',
  price: 11062,
  favorite: false,
  stars: 46649,
  supplier: 'calculate',
};

export const sampleWithFullData: IProduct = {
  id: 'b776a456-8a63-4e85-babd-435b43af8bb9',
  name: 'Pound copy Account',
  price: 33057,
  photo: '../fake-data/blob/hipster.png',
  photoContentType: 'unknown',
  favorite: true,
  description: 'backing Iraqi',
  stars: 30005,
  supplier: 'system harness Clothing',
  tax: 9868,
};

export const sampleWithNewData: NewProduct = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
