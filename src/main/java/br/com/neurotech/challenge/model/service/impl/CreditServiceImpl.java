package br.com.neurotech.challenge.model.service.impl;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.CreditType;
import br.com.neurotech.challenge.model.entity.enums.VehicleModel;
import br.com.neurotech.challenge.model.service.ClientService;
import br.com.neurotech.challenge.model.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final ClientService clientService;

    @Override
    public boolean checkCredit(Long clientId, VehicleModel model) {
        log.info("Checking credit to clientId: <{}> and model: <{}>", clientId, model);
        var clientFound = clientService.get(clientId);

        return model.isEligible(clientFound);
    }

    @Override
    public List<NeurotechClient> getAllClientsEligibleForHatch() {
        log.info("Retrieving all clients eligible for hatch...");

        var minAge = 23;
        var maxAge = 49;
        var minIncome = new BigDecimal("5000.00");
        var maxIncome = new BigDecimal("15000.00");

        return clientService.findAllClientsByFilters(minAge, maxAge, minIncome, maxIncome, CreditType.FIXED_INTEREST);

    }
}
