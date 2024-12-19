package br.com.neurotech.challenge.model.service;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.CreditType;

import java.math.BigDecimal;
import java.util.List;

public interface ClientService {

    /**
     * Saves a new client in the database.
     *
     * @param client the  {@link NeurotechClient} client to be saved
     * @return a string representing the identifier of the saved client
     */
    Long save(NeurotechClient client);

    /**
     * Retrieves a client by its unique identifier.
     *
     * @param id the unique identifier of the client
     * @return the {@link NeurotechClient} object corresponding to the given ID
     */
    NeurotechClient get(Long id);

    List<NeurotechClient> findAllClientsByFilters(int minAge,
                                                  int maxAge,
                                                  BigDecimal minIncome,
                                                  BigDecimal maxIncome,
                                                  CreditType creditType);
}
