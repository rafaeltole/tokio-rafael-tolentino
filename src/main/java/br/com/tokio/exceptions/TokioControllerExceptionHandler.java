package br.com.tokio.exceptions;

import br.com.tokio.model.MensagemRetornoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TokioControllerExceptionHandler {

    private ObjectError e;

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public @ResponseBody MensagemRetornoDTO erroNaoEsperado(Exception erro) {
        return MensagemRetornoDTO.buildComErro("Ocorreu um erro não esperado", erro.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody MensagemRetornoDTO erroValidacaoCampos(MethodArgumentNotValidException erro) {
        StringBuilder erros = new StringBuilder();

        erro.getBindingResult().getAllErrors().forEach(e -> {
            erros.append(e.getDefaultMessage()).append("\n");
        });
        return MensagemRetornoDTO.buildComErro("Valores devem ser informados", erros.toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TaxaNaoEncontradaException.class)
    public @ResponseBody MensagemRetornoDTO erroTaxaNaoEncontrada(TaxaNaoEncontradaException erro) {
        return MensagemRetornoDTO.buildComErro(erro.getMessage(), erro.getMessage());
    }

}
