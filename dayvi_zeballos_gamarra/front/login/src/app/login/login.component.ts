import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { LoginService } from '../services/login.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  filterform: FormGroup;

  constructor(
    private fb: FormBuilder,
    private srvLogin: LoginService,
    private cookieService: CookieService,
    private toast: ToastrService,
    private router: Router
  ) {
    this.filterform = this.fb.group({
      username: new FormControl(null, Validators.required),
      pasword: new FormControl(null, Validators.required),
    });
  }

  ngOnInit(): void {}

  get f() {
    return this.filterform.controls;
  }

  enviarDatos() {
    let request: any = {
      username: this.f.username.value,
      pasword: this.f.pasword.value,
    };

    this.srvLogin.loguin(request).subscribe((mc) => {

      if (mc.acces_token && mc.refresh_token) {
        this.cookieService.set('acces_token', mc.acces_token);
        this.cookieService.set('refresh_token', mc.refresh_token);
        this.router.navigate(['./home']);
      }
    },(error)=>{
        this.toast.warning(`Error de Autentificación`,`Advertencia`);
    });
  }
}
