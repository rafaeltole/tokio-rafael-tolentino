package br.com.tokio.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DataUtils {

    public static int calculaIntervadoEmDias(final LocalDate dataInicial, final LocalDate dataFinal) {
        return Long.valueOf(ChronoUnit.DAYS.between(dataInicial, dataFinal)).intValue();
    }

    public static LocalDateTime obterDataAtual() {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
