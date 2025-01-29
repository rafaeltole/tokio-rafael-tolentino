package br.com.tokio.service;

import br.com.tokio.exceptions.TaxaNaoEncontradaException;
import br.com.tokio.model.Agendamento;
import br.com.tokio.model.AgendamentoRepository;
import br.com.tokio.model.Taxa;
import br.com.tokio.model.TaxaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AgendamentoServiceTest {

    private AgendamentoService service;

    @Mock
    private TaxaRepository taxaRepository;

    @Mock
    private AgendamentoRepository agendamentoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        service = new AgendamentoService(agendamentoRepository, taxaRepository);
    }

    @Test
    public void deveRealizarAgendamentoTransferenciaParaDiaAtual() throws TaxaNaoEncontradaException {
        when(taxaRepository.obterTaxaPorDiasTranferencia(0)).thenReturn(new Taxa(0, 0, new BigDecimal("3.00"), new BigDecimal("2.50")));

        service.agenda(null, null, new BigDecimal("10000.32"), LocalDate.now());

        ArgumentCaptor<Agendamento> argumentCaptor = ArgumentCaptor.forClass(Agendamento.class);
        verify(agendamentoRepository, Mockito.only()).save(argumentCaptor.capture());

        assertEquals(new BigDecimal("253.01"), argumentCaptor.getValue().getTaxa());
        assertEquals(new BigDecimal("10000.32"), argumentCaptor.getValue().getValor());
    }


    @Test
    public void deveRealizarAgendamentoTransferenciaEntre31_40Dias() throws TaxaNaoEncontradaException {
        when(taxaRepository.obterTaxaPorDiasTranferencia(35)).thenReturn(new Taxa(31, 40, ZERO, new BigDecimal("4.70")));

        service.agenda(null, null, new BigDecimal("10000.32"), LocalDate.now().plusDays(35));

        ArgumentCaptor<Agendamento> argumentCaptor = ArgumentCaptor.forClass(Agendamento.class);
        verify(agendamentoRepository, Mockito.only()).save(argumentCaptor.capture());

        assertEquals(new BigDecimal("470.02"), argumentCaptor.getValue().getTaxa());
        assertEquals(new BigDecimal("10000.32"), argumentCaptor.getValue().getValor());
    }

    @Test
    public void deveLancarExcecaoParaUmPeriodoSemTaxaCadastrada() {
        Assertions.assertThrowsExactly(TaxaNaoEncontradaException.class, () -> {
            service.agenda(null, null, new BigDecimal("10000.32"), LocalDate.now().plusDays(70));
        }, "Taxa não encontrada para o período [70] dias");
    }

}
