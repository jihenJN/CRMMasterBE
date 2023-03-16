import { IClient, NewClient } from './client.model';

export const sampleWithRequiredData: IClient = {
  id: 'b5d26ec1-78ed-413c-a418-9dee47137427',
};

export const sampleWithPartialData: IClient = {
  id: 'b403cc41-80b6-4c63-bdc7-591621bc0e72',
  name: 'yellow monitor',
  phone: 27216,
  address: 'Synergized',
  email: 'Anais_Stiedemann@hotmail.com',
};

export const sampleWithFullData: IClient = {
  id: '0de8bf54-c72c-4d83-83fb-d32ffde4b221',
  name: 'Shoes',
  phone: 52368,
  address: 'violet',
  email: 'Zachery13@gmail.com',
};

export const sampleWithNewData: NewClient = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
