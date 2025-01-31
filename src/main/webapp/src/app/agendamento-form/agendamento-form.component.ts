import { Component, ViewChild, Output, EventEmitter, ChangeDetectionStrategy } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgForm } from '@angular/forms'

import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from '@angular/forms';

import {MatDatepickerModule} from '@angular/material/datepicker';
import {provideNativeDateAdapter} from '@angular/material/core';

import { Agendamento } from '../model/agendamento'

@Component({
  selector: 'app-agendamento-form',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [HttpClientModule, MatInputModule, MatFormFieldModule, FormsModule, MatDatepickerModule, MatButtonModule],
  templateUrl: './agendamento-form.component.html',
  styleUrl: './agendamento-form.component.css'
})
export class AgendamentoFormComponent {

  @ViewChild('agendamentoForm') agendamentoForm!: NgForm;

  @Output() output = new EventEmitter();

  readonly minDate = new Date();

  retorno: any = {};

  constructor(private http: HttpClient) {}

  onSubmit(): void {
    this.http.post('http://localhost:8080/tokio-rafael-tolentino/agendamento', this.agendamentoForm.value).subscribe({
      next: data => {
          this.retorno = {mensagem: 'Agendamento cadastrado com sucesso'};
          this.agendamentoForm.reset();
          },
      error: data => {
        this.retorno = {mensagem: data.error.erro};
        this.agendamentoForm.reset();
        }
      });

  }

}
