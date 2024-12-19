package br.com.neurotech.challenge.model.service.impl;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.CreditType;
import br.com.neurotech.challenge.model.exceptions.ClientNotFoundException;
import br.com.neurotech.challenge.model.repository.ClientRepository;
import br.com.neurotech.challenge.model.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Long save(NeurotechClient client) {
        log.info("Saving client with data: <{}>", client);

        var elegibleCreditTypeList = CreditType.getEligibleCreditTypes(client);
        client.setCreditTypes(elegibleCreditTypeList);

        var savedClient = clientRepository.save(client);
        var clientId = savedClient.getId();

        log.info("Client successfully saved with id: <{}>", clientId);
        return clientId;
    }

    @Override
    public NeurotechClient get(Long id) {
        log.info("Finding client with id: <{}>", id);

        var foundClient = clientRepository.findById(id);

        if (foundClient.isEmpty()) {
            throw new ClientNotFoundException(id);
        }

        log.info("Client found with id: <{}>", id);
        return foundClient.get();
    }

    @Override
    public List<NeurotechClient> findAllClientsByFilters(int minAge,
                                                         int maxAge,
                                                         BigDecimal minIncome,
                                                         BigDecimal maxIncome,
                                                         CreditType creditType) {
        log.info("Finding client list by parameters: minAge <{}>, maxAge <{}>, minIncome <{}>, maxIncome <{}>, creditType <{}>",
                minAge, maxAge, minIncome, maxIncome, creditType);

        var foundClientList = clientRepository.findAllClientsByFilters(minAge, maxAge, minIncome, maxIncome, creditType);

        log.info("Clients found total: <{}>", foundClientList.size());
        return foundClientList;
    }
}
