package br.com.tokio.controller;

import br.com.tokio.model.Conta;
import br.com.tokio.service.AgendamentoService;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(final AgendamentoService service) {
        this.service = service;
    }

    public void agenda(final Conta origem, final Conta destino, final BigDecimal valor, String dataParaTranferencia) {
        //TODO Implementar
        service.agenda(origem, destino, valor, dataParaTranferencia);

    }

}
