package br.com.tokio.service;

import br.com.tokio.model.Agendamento;
import br.com.tokio.model.AgendamentoRepository;
import br.com.tokio.model.Conta;
import br.com.tokio.model.TaxaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.math.BigDecimal.ZERO;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    private final TaxaRepository taxaRepository;

    public AgendamentoService(final AgendamentoRepository agendamentoRepository, final TaxaRepository taxaRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.taxaRepository = taxaRepository;
    }

    public void agenda(final Conta origem, final Conta destino, final BigDecimal valor, final String dataParaTranferencia) {
        final Agendamento agendamento = new Agendamento(origem, destino, valor, ZERO, LocalDate.now());

        agendamentoRepository.save(agendamento);
    }

}
