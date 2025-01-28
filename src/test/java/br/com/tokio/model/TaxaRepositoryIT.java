package br.com.tokio.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class TaxaRepositoryIT {

    @Autowired
    private TaxaRepository repository;

    @Test
    public void quandoTransferenciaNoMesmoDia() {
        final Taxa taxa = repository.obterTaxaPorDiasTranferencia(0);
        assertTrue(taxa.getDiaDe() >= 0);
        assertTrue(taxa.getDiaAte() <= 0);
        assertEquals(new BigDecimal("2.50"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("3.00"), taxa.getValor());
    }

    @Test
    public void quandoTransferenciaForEmAte10Dias() {
        Taxa taxa = repository.obterTaxaPorDiasTranferencia(9);
        assertTrue(taxa.getDiaDe() >= 1);
        assertTrue(taxa.getDiaAte() <= 10);
        assertEquals(new BigDecimal("0.00"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("12.00"), taxa.getValor());

        taxa = repository.obterTaxaPorDiasTranferencia(10);
        assertTrue(taxa.getDiaDe() >= 1);
        assertTrue(taxa.getDiaAte() <= 10);
        assertEquals(new BigDecimal("0.00"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("12.00"), taxa.getValor());
    }

    @Test
    public void quandoTransferenciaForEmAte20Dias() {
        Taxa taxa = repository.obterTaxaPorDiasTranferencia(18);
        assertTrue(taxa.getDiaDe() >= 11);
        assertTrue(taxa.getDiaAte() <= 20);
        assertEquals(new BigDecimal("8.20"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());

        taxa = repository.obterTaxaPorDiasTranferencia(20);
        assertTrue(taxa.getDiaDe() >= 11);
        assertTrue(taxa.getDiaAte() <= 20);
        assertEquals(new BigDecimal("8.20"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());
    }

    @Test
    public void quandoTransferenciaForEmAte30Dias() {
        Taxa taxa = repository.obterTaxaPorDiasTranferencia(27);
        assertTrue(taxa.getDiaDe() >= 21);
        assertTrue(taxa.getDiaAte() <= 30);
        assertEquals(new BigDecimal("6.90"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());

        taxa = repository.obterTaxaPorDiasTranferencia(30);
        assertTrue(taxa.getDiaDe() >= 21);
        assertTrue(taxa.getDiaAte() <= 30);
        assertEquals(new BigDecimal("6.90"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());
    }

    @Test
    public void quandoTransferenciaForEmAte40Dias() {
        Taxa taxa = repository.obterTaxaPorDiasTranferencia(38);
        assertTrue(taxa.getDiaDe() >= 31);
        assertTrue(taxa.getDiaAte() <= 40);
        assertEquals(new BigDecimal("4.70"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());

        taxa = repository.obterTaxaPorDiasTranferencia(40);
        assertTrue(taxa.getDiaDe() >= 31);
        assertTrue(taxa.getDiaAte() <= 40);
        assertEquals(new BigDecimal("4.70"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());
    }

    @Test
    public void quandoTransferenciaForEmAte50Dias() {
        Taxa taxa = repository.obterTaxaPorDiasTranferencia(43);
        assertTrue(taxa.getDiaDe() >= 41);
        assertTrue(taxa.getDiaAte() <= 50);
        assertEquals(new BigDecimal("1.70"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());

        taxa = repository.obterTaxaPorDiasTranferencia(50);
        assertTrue(taxa.getDiaDe() >= 41);
        assertTrue(taxa.getDiaAte() <= 50);
        assertEquals(new BigDecimal("1.70"), taxa.getPorcentagem());
        assertEquals(new BigDecimal("0.00"), taxa.getValor());
    }

}
