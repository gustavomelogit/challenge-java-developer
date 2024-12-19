package br.com.neurotech.challenge.controller;


import br.com.neurotech.challenge.model.entity.NeurotechClient;
import br.com.neurotech.challenge.model.entity.enums.VehicleModel;
import br.com.neurotech.challenge.model.service.CreditService;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.RoundingMode;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CreditController.class)
public class CreditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditService creditService;

    private Long clientId;
    private VehicleModel model;
    private NeurotechClient neurotechClient;
    private List<NeurotechClient> neurotechClientList;

    @BeforeEach
    void setup() {
        clientId = 1L;
        model = VehicleModel.HATCH;
        neurotechClient = Instancio.create(NeurotechClient.class);
        neurotechClientList = List.of(neurotechClient);
    }

    @Test
    void shouldCheckCreditEligibility() throws Exception {
        boolean isEligible = true;

        when(creditService.checkCredit(clientId, model)).thenReturn(isEligible);

        mockMvc.perform(get("/eligible-credit")
                        .param("clientId", clientId.toString())
                        .param("model", model.name()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void shouldRetrieveClientsEligibleForHatch() throws Exception {
        when(creditService.getAllClientsEligibleForHatch()).thenReturn(neurotechClientList);

        mockMvc.perform(get("/eligible-credit/hatch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(neurotechClient.getName()))
                .andExpect(jsonPath("$[0].income")
                        .value(neurotechClient.getIncome().setScale(2, RoundingMode.HALF_UP).doubleValue()));
    }
}
