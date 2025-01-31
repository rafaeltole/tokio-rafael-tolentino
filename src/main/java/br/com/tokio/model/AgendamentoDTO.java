package br.com.tokio.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static br.com.tokio.utils.ConverterUtils.dataEm_ddMMyyyy;
import static br.com.tokio.utils.ConverterUtils.valorEmReais;

public class AgendamentoDTO {

    @Min(value = 1, message = "Conta de Origem deve ser maior do que 0")
    @NotBlank(message = "Conta de Origem deve ser informada")
    private String contaOrigem;

    @Min(value = 1, message = "Conta de Destino deve ser maior do que 0")
    @NotBlank(message = "Conta de Destino deve ser informada")
    private String contaDestino;

    private String taxa;

    @Min(value = 1, message = "Valor deve ser maior do que 0")
    @NotBlank(message = "Valor deve ser informado")
    private String valor;

    private String dataAgendamento;

    @NotBlank(message = "Data para transferência deve ser informada")
    private String dataTransferencia;

    public String getContaOrigem() {
        return contaOrigem;
    }

    public Integer obterContaOrigemComoInteiro() {
        return contaOrigem == null ? 0 : Integer.parseInt(contaOrigem);
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public Integer obterContaDestinoComoInteiro() {
        return contaDestino == null ? 0 : Integer.parseInt(contaDestino);
    }

    public String getTaxa() {
        return taxa;
    }

    public String getValor() {
        return valor;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public String getDataTransferencia() {
        return dataTransferencia;
    }

    static AgendamentoDTO build(final Conta origem, final Conta destino, final BigDecimal taxa, final BigDecimal valor, final LocalDateTime dataAgendamento, final LocalDate dataParaTransferencia) {
        AgendamentoDTO dto = new AgendamentoDTO();
        dto.contaOrigem = origem.obterNumeroComoString();
        dto.contaDestino = destino.obterNumeroComoString();
        dto.taxa = valorEmReais(taxa);
        dto.valor = valorEmReais(valor);
        dto.dataAgendamento = dataEm_ddMMyyyy(dataAgendamento);
        dto.dataTransferencia = dataEm_ddMMyyyy(dataParaTransferencia);
        return dto;
    }

}
