export class Agendamento {

  constructor(
    public contaOrigem: string,
    public contaDestino: string,
    public valor: string,
    public taxa: string,
    public dataAgendamento: string,
    public dataTransferencia: string
    ) {}

  }

