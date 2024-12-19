package br.com.neurotech.challenge.model.service;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.VehicleModel;

import java.util.List;

public interface CreditService {

    /**
     * Checks if a client is eligible for credit for a specific vehicle model.
     *
     * @param clientId the unique identifier of the client to be checked
     * @param model    the vehicle model for which the credit eligibility is verified
     * @return {@code true} if the client is eligible for credit based on the vehicle model,
     * {@code false} otherwise
     */
    boolean checkCredit(Long clientId, VehicleModel model);

    /**
     * Retrieves a list of clients eligible for Hatch vehicle financing.
     * Criteria: clients aged 23-49, with Fixed Interest Credit and income between R$ 5000,00 and R$ 15000,00.
     *
     * @return a list of eligible clients, including their name and income
     */
    List<NeurotechClient> getAllClientsEligibleForHatch();
}
