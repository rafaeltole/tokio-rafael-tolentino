package br.com.tokio.controller;

import br.com.tokio.exceptions.TaxaNaoEncontradaException;
import br.com.tokio.model.Conta;
import br.com.tokio.service.AgendamentoService;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(final AgendamentoService service) {
        this.service = service;
    }

    public void agenda(final Conta origem, final Conta destino, final BigDecimal valor, String dataParaTranferencia) throws TaxaNaoEncontradaException {
        //TODO Implementar
        service.agenda(origem, destino, valor, LocalDate.now());

    }

}
