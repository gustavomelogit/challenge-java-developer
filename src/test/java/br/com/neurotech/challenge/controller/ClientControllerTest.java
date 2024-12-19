package br.com.neurotech.challenge.controller;

import br.com.neurotech.challenge.controller.dto.ClientDTO;
import br.com.neurotech.challenge.controller.mapper.ClientMapper;
import br.com.neurotech.challenge.model.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.RoundingMode;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    private ObjectMapper objectMapper;
    private ClientDTO clientDTO;
    private Long clientId;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        clientDTO = Instancio.create(ClientDTO.class);
        clientId = 1L;
    }

    @Test
    void shouldRegisterClient() throws Exception {
        when(clientService.save(any())).thenReturn(clientId);

        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(status().isOk())
                .andExpect(header().string("Location", "http://localhost/client/1"))
                .andExpect(content().string("Client registered successfully"));
    }

    @Test
    void shouldGetClientById() throws Exception {
        when(clientService.get(clientId)).thenReturn(ClientMapper.INSTANCE.dtoToEntity(clientDTO));

        mockMvc.perform(get("/client/{id}", clientId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").value(clientDTO.getAge()))
                .andExpect(jsonPath("$.name").value(clientDTO.getName()))
                .andExpect(jsonPath("$.income")
                        .value(clientDTO.getIncome().setScale(2, RoundingMode.HALF_UP).doubleValue()));
    }
}