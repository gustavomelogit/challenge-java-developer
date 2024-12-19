package br.com.neurotech.challenge.model.repository;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ClientRepository extends JpaRepository<NeurotechClient, Long> {

    @Query("FROM NeurotechClient c " +
            "WHERE c.age BETWEEN :minAge AND :maxAge " +
            "AND c.income BETWEEN :minIncome AND :maxIncome " +
            "AND :creditType MEMBER OF c.creditTypes")
    List<NeurotechClient> findAllClientsByFilters(
            int minAge, int maxAge,
            BigDecimal minIncome, BigDecimal maxIncome,
            CreditType creditType);

}