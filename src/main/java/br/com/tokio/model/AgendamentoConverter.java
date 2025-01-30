package br.com.tokio.model;

import br.com.tokio.utils.ConverterUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.tokio.utils.DataUtils.obterDataAtual;

public class AgendamentoConverter {

    public static List<AgendamentoDTO> converteParaDTO(final List<Agendamento> listaAgendamentos) {
        List<AgendamentoDTO> lista = new ArrayList<>();
        listaAgendamentos.forEach(agendamento -> {
            lista.add(AgendamentoDTO.build(agendamento.getOrigem(), agendamento.getDestino(), agendamento.getTaxa(), agendamento.getValor(), agendamento.getDataAgendamento(), agendamento.getDataParaTransferencia()));

        });
        return lista;
    }

    public static Agendamento converteParaObjeto(final AgendamentoDTO agendamentoDTO) {
        final Conta contaOrigem = new Conta(agendamentoDTO.obterContaOrigemComoInteiro());
        final Conta contaDestino = new Conta(agendamentoDTO.obterContaDestinoComoInteiro());

        BigDecimal valor = ConverterUtils.paraBigDecimal(agendamentoDTO.getValor());
        LocalDate dataParaTransferencia = ConverterUtils.paraLocalDate(agendamentoDTO.getDataTransferencia());

        return new Agendamento(contaOrigem, contaDestino, valor, obterDataAtual(), dataParaTransferencia);
    }

}
