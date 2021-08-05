import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { CajerosService } from 'src/app/service/cajeros.service';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.css'],
})
export class AdministrationComponent implements OnInit {
  dataSource: MatTableDataSource<any>;

  displayedColumns = [
    'id',
    'nombreCajero',
    'exclusivo',
    'normal',
    'atenciónPreferencial',
  ];

  constructor(private cajerosService: CajerosService) {}

  ngOnInit(): void {
    this.LoadCajeros();
  }

  CambiarExlusivo(cajeroId: number) {
    this.cajerosService.CambiarExclusivo(cajeroId).subscribe((res) => {
      this.LoadCajeros();
    });
  }
  CambiarNormal(cajeroId: number) {
    this.cajerosService.CambiarNormal(cajeroId).subscribe((res) => {
      this.LoadCajeros();
    });
  }
  CambiarPreferencial(cajeroId: number) {
    this.cajerosService.CambiarPreferencial(cajeroId).subscribe((res) => {
      this.LoadCajeros();
    });
  }

  LoadCajeros() {
    this.cajerosService.ListCajeros().subscribe((data) => {
      console.log();
      this.dataSource = new MatTableDataSource<any>(data);
    });
  }
}
