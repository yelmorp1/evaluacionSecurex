import { environment } from 'src/environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit } from '@angular/core';

import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { CajerosService } from 'src/app/service/cajeros.service';



@Component({
  selector: 'app-monitoring',
  templateUrl: './monitoring.component.html',
  styleUrls: ['./monitoring.component.css'],
})
export class MonitoringComponent implements OnInit {
  dataSource: MatTableDataSource<any>;

  displayedColumns = ['id', 'nombreCajero', 'estado', 'ticket', 'cliente'];

  private stompClient = null;


  constructor(private cajerosService: CajerosService) {}

  ngOnInit(): void {
    this.LoadCajeros();
  }

  connect() {

    const socket = new SockJS(`${environment.socketUrl}/socket-cajeros`);
    this.stompClient = Stomp.over(socket);
    const _this = this;

    this.stompClient.heartbeat.outgoing = 5000;
    this.stompClient.heartbeat.incoming = 5000;

    this.stompClient.connect({}, (frame) => {
      console.log('Connected: ' + frame);
      _this.stompClient.subscribe(
        '/cajeros-app-out/socket-listar-cajeros',
        (res) => {
          console.log('rpta ' + res);
          console.log('rpta body ' + res.body);
          let data: Monitoreo[] = [];
          data = JSON.parse(res.body);
          data.map((row) => {
            console.log('row : ', row);
          });
          this.dataSource = new MatTableDataSource<Monitoreo>(data);
        }
      );
      _this.stompClient.subscribe('/cajeros-app-out/bit', (res) => {
        console.log('data : ', res.body);
      });
    });
  }

  LoadCajeros() {
    this.cajerosService.ListCajeros().subscribe((data) => {
      console.log();
      this.dataSource = new MatTableDataSource<any>(data);
      this.connect();
    });
  }
}

interface Monitoreo {
  idCajero: number;
  nombreCajero: string;
  exclusivo: boolean;
  normal: boolean;
  preferencial: boolean;
  ticket: number;
  cliente: string;
  estado: boolean;
}
