package br.com.tokio.controller;

import br.com.tokio.exceptions.TaxaNaoEncontradaException;
import br.com.tokio.model.Agendamento;
import br.com.tokio.model.AgendamentoDTO;
import br.com.tokio.model.AgendamentoConverter;
import br.com.tokio.model.Conta;
import br.com.tokio.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static br.com.tokio.model.AgendamentoConverter.converteParaDTO;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(final AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> agenda(@RequestBody AgendamentoDTO agendamentoDTO) throws TaxaNaoEncontradaException {
        Agendamento agendamento = AgendamentoConverter.converteParaObjeto(agendamentoDTO);
        service.agenda(agendamento);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<AgendamentoDTO> lista() {
        final List<Agendamento> listaAgendamentos = service.lista();
        return converteParaDTO(listaAgendamentos);
    }

}
