package br.com.tokio.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conta_origem_id")
    private final Conta origem;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conta_destino_id")
    private final Conta destino;

    @Column(scale = 2, nullable = false)
    private final BigDecimal valor;

    @Column(scale = 2, nullable = false)
    private BigDecimal taxa;

    @Column(nullable = false)
    private final LocalDateTime dataAgendamento;

    @Column(nullable = false)
    private final LocalDate dataParaTransferencia;

    Agendamento() {
        this(null, null, null, null, null);
    }

    public Agendamento(final Conta origem, final Conta destino, final BigDecimal valor, LocalDateTime dataAgendamento, final LocalDate dataParaTransferencia) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.dataAgendamento = dataAgendamento;
        this.dataParaTransferencia = dataParaTransferencia;
    }

    public Long getId() {
        return id;
    }

    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void atualizaValorTaxa(final BigDecimal taxa) {
        this.taxa = taxa;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDate getDataParaTransferencia() {
        return dataParaTransferencia;
    }

    @Override
    public String toString() {
        return String.format("Agendamento [id=%s] [origem=%s] [destino=%s] [valor=%s] [taxa=%s]", id, origem, destino, valor, taxa);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Agendamento)) return false;
        final Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id) && Objects.equals(origem, that.origem) && Objects.equals(destino, that.destino) && Objects.equals(valor, that.valor) && Objects.equals(taxa, that.taxa) && Objects.equals(dataAgendamento, that.dataAgendamento) && Objects.equals(dataParaTransferencia, that.dataParaTransferencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origem, destino, valor, taxa, dataAgendamento, dataParaTransferencia);
    }

}
