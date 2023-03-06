import { IClient, NewClient } from './client.model';

export const sampleWithRequiredData: IClient = {
  id: 'b5d26ec1-78ed-413c-a418-9dee47137427',
};

export const sampleWithPartialData: IClient = {
  id: '03cc4180-b6c6-43fd-8759-1621bc0e7263',
  name: 'input',
  phone: 32535,
  address: 'contextually-based',
  email: 'Tina_Bednar71@gmail.com',
  orders: 3723,
};

export const sampleWithFullData: IClient = {
  id: 'de8bf54c-72cd-4838-bfbd-32ffde4b2213',
  name: 'Borders',
  phone: 21556,
  address: 'e-commerce',
  email: 'Adrienne64@hotmail.com',
  orders: 64510,
  fidelityCard: true,
};

export const sampleWithNewData: NewClient = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
