import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component'
import { AgendamentoListComponent } from './agendamento-list/agendamento-list.component'
import { AgendamentoFormComponent } from './agendamento-form/agendamento-form.component'


export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'agendamento-list', component: AgendamentoListComponent},
  { path: 'agendamento-form', component: AgendamentoFormComponent}
  ];
