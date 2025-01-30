package br.com.tokio.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TaxaRepository extends CrudRepository<Taxa, Long> {

    @Query("SELECT taxa FROM Taxa taxa WHERE taxa.diaAte >= :qtdDiasTransferencia AND taxa.diaDe <= :qtdDiasTransferencia")
    Taxa obterTaxaPorDiasTranferencia(@Param("qtdDiasTransferencia") int qtdDiasTransferencia);

}
