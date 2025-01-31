import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { Agendamento } from '../model/agendamento'


@Component({
  selector: 'app-agendamento-list',
  standalone: true,
  imports: [HttpClientModule, MatTableModule],
  templateUrl: './agendamento-list.component.html',
  styleUrl: './agendamento-list.component.css'
})
export class AgendamentoListComponent {
  displayedColumns: string[] = ['contaOrigem', 'contaDestino', 'valor', 'taxa', 'dataAgendamento', 'dataTransferencia'];

  agendamentos: Agendamento[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
      this.http.get<Agendamento[]>('http://localhost:8080/tokio-rafael-tolentino/agendamento').subscribe((data: Agendamento[]) => {
        this.agendamentos = data;
      });
    }

}
