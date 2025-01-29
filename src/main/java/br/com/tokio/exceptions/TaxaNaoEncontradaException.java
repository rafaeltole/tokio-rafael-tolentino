package br.com.tokio.exceptions;

public class TaxaNaoEncontradaException extends Exception {

    public TaxaNaoEncontradaException(long qtdDiasTransferencia) {
        super(String.format("Taxa não encontrada para o período [%s] dias", qtdDiasTransferencia));
    }

}
