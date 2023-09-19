import { Injectable } from '@angular/core';
import { URL_SERVICE } from '../config/config';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/User.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRegisterService {

  private URL = URL_SERVICE;
  constructor(private http: HttpClient) { }

  userRegister(user : User):Observable<any>{
    return this.http.post(`${this.URL}users/save`, user);
  }

  editRegister(user : User):Observable<any>{    
    return this.http.put(`${this.URL}users/${user.idUser}`, user);
  }

  logOut(){
    localStorage.removeItem("token");
    localStorage.removeItem("user");

  }
}
