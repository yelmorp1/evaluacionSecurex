import { TicketService } from './../../service/ticket.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css'],
})
export class TicketComponent implements OnInit {
  nombre: string;
  nombreCliente: string;
  ticket: number;
  edad: number;
  constructor(private ticketService: TicketService) {}

  ngOnInit(): void {}

  generarTicket() {
    this.ticketService.GenerarTicket(this.nombre).subscribe((res) => {
      console.log('generarTicket', res);
      this.ticket = res.idColaTicket;
      this.nombreCliente = res.nombreCliente;
      this.edad = res.edad;
    });
  }
}
