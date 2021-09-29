import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class HttpInterceptor implements HttpInterceptor {
  constructor(private cookieService: CookieService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    const acces_token = this.cookieService.get('acces_token');
    //const refresh_token = this.cookieService.get('refresh_token');

    if (acces_token) {
      const cloned = request.clone({
        headers: request.headers.set('Authorization', 'Bearer ' + acces_token),
          //.set('refresh_token', refresh_token),
      });

      return next.handle(cloned);
    } else {
      return next.handle(request);
    }
  }
}
