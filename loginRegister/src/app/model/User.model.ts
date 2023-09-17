export interface User {
  idUser?: string;
  name?: string;
  email?: string;
  password?: string;
  token?: string;
  active?: Boolean;
  phone?: Phone;
  lastLogin?: Date;
  created?: Date;
  modified?: Date;
}
export interface Phone {
  id?: number;
  number?: number;
  cityCode?: number;
  countryCode?: number;
}
