package br.com.tokio.exceptions;

public class TaxaNaoEncontradaException extends Exception {

    public TaxaNaoEncontradaException(long qtdDiasTransferencia) {
        super(String.format("O período de [%s] dias não possui taxa cadastrada", qtdDiasTransferencia));
    }

}
