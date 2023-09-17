import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { URL_SERVICE } from '../config/config';
import { User } from '../model/User.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private URL = URL_SERVICE;
  constructor(private http: HttpClient) { }

  login(user : User): Observable<any>{
    return this.http.post(`${this.URL}authenticate`, user);
  }

  isLoggedIn(){
    // If token exists return true, else return false.
    return !!localStorage.getItem('token');
  }
}
