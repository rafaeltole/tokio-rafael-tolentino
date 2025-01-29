package br.com.tokio.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxaTest {

    private final BigDecimal valorTransferencia = new BigDecimal("10000");

    @Test
    public void deveCalcularOValorTaxaTransferenciaAgendadaMesmoDia() {
        final Taxa taxa = new Taxa(0, 0, new BigDecimal("3.00"), new BigDecimal("2.50"));
        final BigDecimal valorTaxa = taxa.calcula(valorTransferencia);
        assertEquals(new BigDecimal("253.00"), valorTaxa);
    }

    @Test
    public void deveCalcularOValorTaxaTransferenciaAgendamentoEntre1_10Dias() {
        final Taxa taxa = new Taxa(1, 10, new BigDecimal("12.00"), ZERO);
        final BigDecimal valorTaxa = taxa.calcula(valorTransferencia);
        assertEquals(new BigDecimal("12.00"), valorTaxa);
    }

    @Test
    public void deveCalcularOValorTaxaTransferenciaAgendamentoEntre11_20Dias() {
        final Taxa taxa = new Taxa(11, 20, ZERO, new BigDecimal("8.20"));
        final BigDecimal valorTaxa = taxa.calcula(valorTransferencia);
        assertEquals(new BigDecimal("820.00"), valorTaxa);
    }

    @Test
    public void deveCalcularOValorTaxaTransferenciaAgendamentoEntre21_30Dias() {
        final Taxa taxa = new Taxa(21, 30, ZERO, new BigDecimal("6.90"));
        final BigDecimal valorTaxa = taxa.calcula(valorTransferencia);
        assertEquals(new BigDecimal("690.00"), valorTaxa);
    }

    @Test
    public void deveCalcularOValorTaxaTransferenciaAgendamentoEntre31_40Dias() {
        final Taxa taxa = new Taxa(31, 40, ZERO, new BigDecimal("4.70"));
        final BigDecimal valorTaxa = taxa.calcula(valorTransferencia);
        assertEquals(new BigDecimal("470.00"), valorTaxa);
    }

    @Test
    public void deveCalcularOValorTaxaTransferenciaAgendamentoEntre41_50Dias() {
        final Taxa taxa = new Taxa(41, 50, ZERO, new BigDecimal("1.70"));
        final BigDecimal valorTaxa = taxa.calcula(valorTransferencia);
        assertEquals(new BigDecimal("170.00"), valorTaxa);
    }

}
