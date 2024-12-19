package br.com.neurotech.challenge.model.service.impl;


import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.CreditType;
import br.com.neurotech.challenge.model.exceptions.ClientNotFoundException;
import br.com.neurotech.challenge.model.repository.ClientRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    private NeurotechClient client;
    private List<NeurotechClient> clientList;

    @BeforeEach
    void setUp() {
        client = Instancio.create(NeurotechClient.class);
        clientList = List.of(client);
    }

    @Test
    @DisplayName("Should save a client and return client id")
    void shouldSaveClient() {
        when(clientRepository.save(any())).thenReturn(client);

        var clientId = clientService.save(client);

        assertNotNull(clientId);
        assertEquals(client.getId(), clientId);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    @DisplayName("Should get client when found")
    void shouldGetClientWhenFound() {
        var clientId = 1L;
        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));

        var result = clientService.get(clientId);

        assertEquals(client, result);
        verify(clientRepository, times(1)).findById(clientId);
    }

    @Test
    @DisplayName("Should throw ClientNotFoundException if client is not found")
    void shouldThrowExceptionWhenClientNotFound() {
        var clientId = 1L;
        when(clientRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ClientNotFoundException.class, () -> clientService.get(clientId));

        verify(clientRepository, times(1)).findById(clientId);
    }

    @Test
    @DisplayName("Should find clients by filters")
    void shouldFindClientsByFilters() {
        int minAge = 25;
        int maxAge = 40;
        var minIncome = new BigDecimal("10000.00");
        var maxIncome = new BigDecimal("15000.00");
        var creditType = CreditType.FIXED_INTEREST;

        when(clientRepository.findAllClientsByFilters(minAge, maxAge, minIncome, maxIncome, creditType))
                .thenReturn(clientList);

        var result = clientService.findAllClientsByFilters(minAge, maxAge, minIncome, maxIncome, creditType);

        assertNotNull(result);
        assertEquals(clientList.size(), result.size());
        assertEquals(clientList, result);
        verify(clientRepository, times(1))
                .findAllClientsByFilters(minAge, maxAge, minIncome, maxIncome, creditType);
    }
}