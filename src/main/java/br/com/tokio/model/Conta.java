package br.com.tokio.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10, nullable = false)
    private final Integer numero;

    Conta() {
        this(null);
    }

    public Conta(final Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return String.format("Conta [id=%s] [numero=%s]", id, numero);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        final Conta conta = (Conta) o;
        return Objects.equals(id, conta.id) && Objects.equals(numero, conta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero);
    }

}
