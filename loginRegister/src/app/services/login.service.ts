import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { URL_SERVICE } from '../config/config';
import { User } from '../model/User.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private URL = URL_SERVICE;
  constructor(private http: HttpClient) { }

  login(user : User){
    return this.http.post(`${this.URL}authenticate`, user);
  }
}
