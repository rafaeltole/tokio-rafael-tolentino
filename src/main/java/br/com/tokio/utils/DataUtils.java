package br.com.tokio.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataUtils {

    public static long calculaIntervadoEmDias(final LocalDate dataInicial, final LocalDate dataFinal) {
        return ChronoUnit.DAYS.between(dataInicial, dataFinal);
    }

}
