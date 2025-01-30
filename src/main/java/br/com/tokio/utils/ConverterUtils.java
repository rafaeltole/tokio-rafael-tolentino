package br.com.tokio.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class ConverterUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATE_FORMATTER_ISO = DateTimeFormatter.ISO_DATE_TIME;
    private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public static int calculaIntervadoEmDias(final LocalDate dataInicial, final LocalDate dataFinal) {
        return Long.valueOf(ChronoUnit.DAYS.between(dataInicial, dataFinal)).intValue();
    }

    public static String valorEmReais(final BigDecimal valor) {
        return NUMBER_FORMATTER.format(valor.doubleValue());
    }

    public static String dataEm_ddMMyyyy(final LocalDateTime data) {
        return dataEm_ddMMyyyy(data.toLocalDate());
    }

    public static String dataEm_ddMMyyyy(final LocalDate data) {
        return DATE_FORMATTER.format(data);
    }

    public static BigDecimal paraBigDecimal(final String valor) {
//        try {
//            return BigDecimal.valueOf(NUMBER_FORMATTER.parse(valor).doubleValue());
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        return new BigDecimal(valor);
    }

    public static LocalDate paraLocalDate(final String data) {
        return LocalDate.from(DATE_FORMATTER_ISO.parse(data));
    }

}
