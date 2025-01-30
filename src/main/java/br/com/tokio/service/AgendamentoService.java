package br.com.tokio.service;

import br.com.tokio.exceptions.TaxaNaoEncontradaException;
import br.com.tokio.model.*;
import br.com.tokio.utils.DataUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    private final TaxaRepository taxaRepository;

    public AgendamentoService(final AgendamentoRepository agendamentoRepository, final TaxaRepository taxaRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.taxaRepository = taxaRepository;
    }

    public void agenda(final Agendamento agendamento) throws TaxaNaoEncontradaException {
        int qtdDiasTransferencia = DataUtils.calculaIntervadoEmDias(LocalDate.now(), agendamento.getDataParaTransferencia());

        final Taxa taxa = taxaRepository.obterTaxaPorDiasTranferencia(qtdDiasTransferencia);
        if (taxa == null) {
            throw new TaxaNaoEncontradaException(qtdDiasTransferencia);
        }

        BigDecimal valorTaxa = taxa.calcula(agendamento.getValor());
        agendamento.atualizaValorTaxa(valorTaxa);

        agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> lista() {
        return (List<Agendamento>) agendamentoRepository.findAll();
    }


}
