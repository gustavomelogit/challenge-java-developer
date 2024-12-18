package br.com.neurotech.challenge.model.service.impl;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.exceptions.ClientNotFoundException;
import br.com.neurotech.challenge.model.repository.ClientRepository;
import br.com.neurotech.challenge.model.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    /**
     * Saves a new client in the database.
     *
     * @param client the  {@link NeurotechClient} client to be saved
     * @return a string representing the identifier of the saved client
     */
    @Override
    public Long save(NeurotechClient client) {
        log.info("Saving client with data: <{}>", client);

        var savedClient = clientRepository.save(client);
        var clientId = savedClient.getId();

        log.info("Client successfully saved with id: <{}>", clientId);
        return clientId;
    }

    /**
     * Retrieves a client by its unique identifier.
     *
     * @param id the unique identifier of the client
     * @return the {@link NeurotechClient} object corresponding to the given ID
     */
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
}
