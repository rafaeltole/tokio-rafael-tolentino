package br.com.tokio;

import br.com.tokio.model.Taxa;
import br.com.tokio.model.TaxaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

@SpringBootApplication
public class Main {

    private final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner cadastraTaxa(TaxaRepository repository) {
        return (args -> {
            repository.save(new Taxa(0, 0, new BigDecimal("3.00"), new BigDecimal("2.5")));
            repository.save(new Taxa(1, 10, new BigDecimal("12.00"), ZERO));
            repository.save(new Taxa(11, 20, ZERO, new BigDecimal("8.20")));
            repository.save(new Taxa(21, 30, ZERO, new BigDecimal("6.90")));
            repository.save(new Taxa(31, 40, ZERO, new BigDecimal("4.70")));
            repository.save(new Taxa(41, 50, ZERO, new BigDecimal("1.70")));

            repository.findAll().forEach(taxa -> {
                logger.info("Taxa cadastrada [{}]", taxa);
            });
        });
    }
}
