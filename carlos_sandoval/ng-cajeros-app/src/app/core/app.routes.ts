import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministrationComponent } from '../pages/administration/administration.component';
import { MonitoringComponent } from '../pages/monitoring/monitoring.component';
import { TicketComponent } from '../pages/ticket/ticket.component';

const routes: Routes = [
  {
    path: 'home',
    // component: HomeComponent,
    children: [
      { path: 'administration', component: AdministrationComponent },
      { path: 'monitoring', component: MonitoringComponent },
      { path: 'ticket-service', component: TicketComponent },
    ],
  },
  {
    path: '**',
    redirectTo: 'home/administration',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
