import { IProduct, NewProduct } from './product.model';

export const sampleWithRequiredData: IProduct = {
  id: 'c442dfc5-f1e3-4a23-b568-16f6b07dcadc',
};

export const sampleWithPartialData: IProduct = {
  id: 'b05732e9-cd25-4315-bfe3-a45b5084becc',
  name: 'frictionless payment Soft',
  price: 22265,
  description: 'structure lime',
  inStock: 44267,
};

export const sampleWithFullData: IProduct = {
  id: '6a4568a6-3e85-4bab-9435-b43af8bb9bbc',
  name: 'copy Account orchestration',
  price: 84770,
  photo: '../fake-data/blob/hipster.png',
  photoContentType: 'unknown',
  description: 'Rapid',
  tax: 42945,
  inStock: 30005,
};

export const sampleWithNewData: NewProduct = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
