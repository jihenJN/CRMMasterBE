import { IProduct, NewProduct } from './product.model';

export const sampleWithRequiredData: IProduct = {
  id: 'c442dfc5-f1e3-4a23-b568-16f6b07dcadc',
};

export const sampleWithPartialData: IProduct = {
  id: '05732e9c-d253-4153-be3a-45b5084beccd',
  name: 'intuitive SDR',
  price: 76296,
  favorite: false,
  stars: 22265,
  supplier: 'structure lime',
};

export const sampleWithFullData: IProduct = {
  id: '76a4568a-63e8-45ba-bd43-5b43af8bb9bb',
  name: 'Mobility generating National',
  price: 39081,
  photo: '../fake-data/blob/hipster.png',
  photoContentType: 'unknown',
  favorite: true,
  description: 'Rapid',
  stars: 42945,
  supplier: 'Legacy',
};

export const sampleWithNewData: NewProduct = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
