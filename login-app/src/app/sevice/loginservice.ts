import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegisters } from '../model/UserRegisters';
import { UserDetails } from '../model/UserDetails';

@Injectable({
  providedIn: 'root',
})
export class Loginservice {
  constructor(private httpclient: HttpClient) {}

  getSubmitRegisterData(formData: UserRegisters): Observable<any> {
    return this.httpclient.post('http://localhost:8080/register', formData);
  }

  getLogin(userRegister: UserRegisters): Observable<{ token: string }> {
    return this.httpclient.post<{ token: string }>(
      'http://localhost:8080/login',
      userRegister
    );
  }

  getUserDetails(): Observable<UserDetails> {
  // const token = localStorage.getItem('authToken'); 
  // const headers = {
  //   'Authorization': `Bearer ${token}`
  // };

  return this.httpclient.get<UserDetails>('http://localhost:8080/user-details');
}

}
