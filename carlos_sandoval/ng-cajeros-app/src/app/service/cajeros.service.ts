import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { BasicService } from '../core/basic-services';

@Injectable({ providedIn: 'root' })
export class CajerosService extends BasicService {
  constructor(public router: Router, private httpClient: HttpClient) {
    super(router);
  }

  ListCajeros(): Observable<any> {
    const options = this.getOptions();
    console.log('ListCajeros:');
    return this.httpClient
      .get<any>(environment.baseUrl + '/listar-cajeros', options)
      .pipe(
        map((data) => {
          console.log('ListCajeros map:', data);
          return this.manageResponse(data);
        }),
        catchError((error: any) => {
          console.log('ListCajeros error:', error);
          return this.manageError(error);
        })
      );
  }

  CambiarExclusivo(cajeroId: number): Observable<void> {
    const options = this.getOptions();
    return this.httpClient
      .get<any>(
        `${environment.baseUrl}/actualizar-exclusivo/${cajeroId}`,
        options
      )
      .pipe(
        map((data) => {
          console.log('CambiarExclusivo map:', data);
          return this.manageResponse(data);
        }),
        catchError((error: any) => {
          console.log('CambiarExclusivo error:', error);
          return this.manageError(error);
        })
      );
  }
  CambiarNormal(cajeroId: number): Observable<void> {
    const options = this.getOptions();
    return this.httpClient
      .get<any>(`${environment.baseUrl}/actualizar-normal/${cajeroId}`, options)
      .pipe(
        map((data) => {
          console.log('CambiarNormal map:', data);
          return this.manageResponse(data);
        }),
        catchError((error: any) => {
          console.log('CambiarNormal error:', error);
          return this.manageError(error);
        })
      );
  }
  CambiarPreferencial(cajeroId: number): Observable<void> {
    const options = this.getOptions();
    return this.httpClient
      .get<any>(
        `${environment.baseUrl}/actualizar-preferencial/${cajeroId}`,
        options
      )
      .pipe(
        map((data) => {
          console.log('CambiarPreferencial map:', data);
          return this.manageResponse(data);
        }),
        catchError((error: any) => {
          console.log('CambiarPreferencial error:', error);
          return this.manageError(error);
        })
      );
  }
}
