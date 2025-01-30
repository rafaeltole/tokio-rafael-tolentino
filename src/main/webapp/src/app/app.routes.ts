import { Routes } from '@angular/router';
import { AgendamentoListComponent } from './agendamento-list/agendamento-list.component'
import { AgendamentoFormComponent } from './agendamento-form/agendamento-form.component'


export const routes: Routes = [
  { path: '', redirectTo: '/agendamento-list', pathMatch: 'full' },
  { path: 'agendamento-list', component: AgendamentoListComponent},
  { path: 'agendamento-form', component: AgendamentoFormComponent}
  ];
