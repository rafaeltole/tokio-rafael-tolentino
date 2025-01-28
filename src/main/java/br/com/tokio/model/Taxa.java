package br.com.tokio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Taxa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(scale = 2, nullable = false)
    private final BigDecimal valor;

    @Column(scale = 2, nullable = false)
    private final BigDecimal porcentagem;

    @Column(nullable = false)
    private final Integer diaDe;

    @Column(nullable = false)
    private final Integer diaAte;

    Taxa() {
        this(null, null, null, null);
    }

    public Taxa(Integer diaDe, Integer diaAte, BigDecimal valor, BigDecimal porcentagem) {
        this.diaDe = diaDe;
        this.diaAte = diaAte;
        this.valor = valor;
        this.porcentagem = porcentagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public Integer getDiaDe() {
        return diaDe;
    }

    public Integer getDiaAte() {
        return diaAte;
    }

    @Override
    public String toString() {
        return String.format("Taxa [id=%s] [diaDe=%s] [diaAte=%s] [valor=%s] [porcentagem=%s]", id, diaDe, diaAte, valor, porcentagem);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Taxa)) return false;
        final Taxa taxa = (Taxa) o;
        return Objects.equals(id, taxa.id) && Objects.equals(valor, taxa.valor) && Objects.equals(porcentagem, taxa.porcentagem) && Objects.equals(diaDe, taxa.diaDe) && Objects.equals(diaAte, taxa.diaAte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, porcentagem, diaDe, diaAte);
    }

}
