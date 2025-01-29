package br.com.tokio.service;

import br.com.tokio.exceptions.TaxaNaoEncontradaException;
import br.com.tokio.model.*;
import br.com.tokio.utils.DataUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    private final TaxaRepository taxaRepository;

    public AgendamentoService(final AgendamentoRepository agendamentoRepository, final TaxaRepository taxaRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.taxaRepository = taxaRepository;
    }

    public void agenda(final Conta origem, final Conta destino, final BigDecimal valor, final LocalDate dataParaTranferencia) throws TaxaNaoEncontradaException {
        long qtdDiasTransferencia = DataUtils.calculaIntervadoEmDias(LocalDate.now(), dataParaTranferencia);

        final Taxa taxa = taxaRepository.obterTaxaPorDiasTranferencia(qtdDiasTransferencia);
        if (taxa == null) {
            throw new TaxaNaoEncontradaException(qtdDiasTransferencia);
        }

        BigDecimal valorTaxa = taxa.calcula(valor);
        final Agendamento agendamento = new Agendamento(origem, destino, valor, valorTaxa, dataParaTranferencia);

        agendamentoRepository.save(agendamento);
    }

}
