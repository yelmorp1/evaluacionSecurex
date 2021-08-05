import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { BasicService } from '../core/basic-services';

@Injectable({ providedIn: 'root' })
export class TicketService extends BasicService {
  constructor(public router: Router, private httpClient: HttpClient) {
    super(router);
  }

  GenerarTicket(nombreCliente: string): Observable<any> {
    const options = this.getOptions();
    return this.httpClient
      .post<any>(
        `${environment.baseUrl}/generar-ticket/`,
        { nombre: nombreCliente },
        options
      )
      .pipe(
        map((data) => {
          console.log('GenerarTicket map:', data);
          return this.manageResponse(data);
        }),
        catchError((error: any) => {
          console.log('GenerarTicket error:', error);
          return this.manageError(error);
        })
      );
  }
}
