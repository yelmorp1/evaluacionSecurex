import { Router } from '@angular/router';
import { of } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

export abstract class BasicService {
  constructor(public router: Router) {}

  protected getOptions() {
    let options = {
      headers: new HttpHeaders({
        Accept: 'application/json',
        'Content-Type': 'application/json',
      }),
    };

    return options;
  }

  manageResponse = (data) => {
    console.log('data');
    console.log(data);
    if (data) {
      return data;
    } else {
      return null;
    }
  };

  manageError = (error) => {
    console.log('error');
    console.log(error);
    return of(error.message);
  };
}
