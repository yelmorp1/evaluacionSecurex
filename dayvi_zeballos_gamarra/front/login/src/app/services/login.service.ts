import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  dominio: string = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  loguin(request: any): Observable<any> {
    const url = `${this.dominio}/login?username=${request.username}&pasword=${request.pasword}`;
    return this.http.get(url);
  }

  listarUsuarios(): Observable<any>{
    const url = `${this.dominio}/usuarios`;
    return this.http.get(url);
  }

  refreshToken(): Observable<any>{
    const url = `${this.dominio}/token/refresh`;
    return this.http.get(url);
  }
}
