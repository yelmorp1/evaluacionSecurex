import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { ToastrService } from 'ngx-toastr';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  lstUsuarios: any = [];

  constructor(
    private srvLogin: LoginService,
     private router: Router,
     private toast: ToastrService,
     private cookieService: CookieService,) {}

  ngOnInit(): void {}

  listarUsuarios() {
    this.srvLogin.listarUsuarios().subscribe((cm) => {
        this.lstUsuarios = cm;
        console.log(this.lstUsuarios);

    },(error) =>{
      if(error.error.error_expired === 'refreshToken'){
        let refreshToken = this.cookieService.get('refresh_token');
        this.cookieService.set('acces_token', refreshToken);
        this.refreshToken();
      }
    });
  }

  refreshToken(){
    this.srvLogin.refreshToken().subscribe((cm) => {
      this.cookieService.set('acces_token', cm.acces_token);
      this.listarUsuarios();
    });
  }

  cerrarSesion(){
    this.cookieService.deleteAll();
    this.router.navigate(['./login']);
  }
}
