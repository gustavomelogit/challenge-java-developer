package br.com.neurotech.challenge.model.service.impl;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.VehicleModel;
import br.com.neurotech.challenge.model.service.ClientService;
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

import static br.com.neurotech.challenge.model.entity.enums.CreditType.FIXED_INTEREST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreditServiceImplTest {

    @InjectMocks
    private CreditServiceImpl creditService;

    @Mock
    private ClientService clientService;

    private NeurotechClient client;

    @BeforeEach
    void setUp() {
        client = Instancio.create(NeurotechClient.class);
    }

    @Test
    @DisplayName("Should return true when credit is eligible for the client and vehicle model")
    void shouldReturnTrueWhenCreditIsEligible() {
        var clientId = 1L;
        var model = VehicleModel.HATCH;
        client.setIncome(new BigDecimal("5000.00"));

        when(clientService.get(any())).thenReturn(client);

        var isEligible = creditService.checkCredit(clientId, model);

        assertTrue(isEligible);
        verify(clientService, times(1)).get(clientId);
    }

    @Test
    @DisplayName("Should return false when credit is not eligible for the client and vehicle model")
    void shouldReturnFalseWhenCreditIsNotEligible() {
        var clientId = 1L;
        var model = VehicleModel.HATCH;
        client.setIncome(new BigDecimal("4000.00"));

        when(clientService.get(any())).thenReturn(client);

        var isEligible = creditService.checkCredit(clientId, model);

        assertFalse(isEligible);
        verify(clientService, times(1)).get(clientId);
    }

    @Test
    @DisplayName("Should retrieve all clients eligible for hatch")
    void shouldRetrieveAllClientsEligibleForHatch() {
        var eligibleClients = List.of(client);
        int minAge = 23;
        int maxAge = 49;
        BigDecimal minIncome = new BigDecimal("5000.00");
        BigDecimal maxIncome = new BigDecimal("15000.00");

        when(clientService.findAllClientsByFilters(minAge, maxAge, minIncome, maxIncome, FIXED_INTEREST))
                .thenReturn(eligibleClients);

        var result = creditService.getAllClientsEligibleForHatch();

        assertNotNull(result);
        assertEquals(eligibleClients.size(), result.size());
        assertEquals(eligibleClients, result);
        verify(clientService, times(1))
                .findAllClientsByFilters(minAge, maxAge, minIncome, maxIncome, FIXED_INTEREST);
    }
}