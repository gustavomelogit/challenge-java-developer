package br.com.neurotech.challenge.controller;


import br.com.neurotech.challenge.config.ApiConfig;
import br.com.neurotech.challenge.controller.annotation.DefaultApiDocumentation;
import br.com.neurotech.challenge.controller.dto.ClientDTO;
import br.com.neurotech.challenge.controller.mapper.ClientMapper;
import br.com.neurotech.challenge.model.service.ClientService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Tag(name = "Neurotech Client", description = "Endpoints for managing neurotech client")
public class ClientController {

    private final ClientService clientService;
    private final ApiConfig apiConfig;

    /**
     * Registers a new client.
     *
     * @param clientDTO the client information to be registered
     * @return a {@link ResponseEntity} with the "Location" header containing the URL of the registered client
     */
    @PostMapping
    @DefaultApiDocumentation(
            summary = "Register a new client",
            description = "Registers a new client and returns the URL to access the created client in the response header"
    )
    public ResponseEntity<String> register(
            @RequestBody ClientDTO clientDTO) {

        var clientId = clientService.save(ClientMapper.INSTANCE.dtoToEntity(clientDTO));

        var location = String.join("/", apiConfig.getApiBaseUrl(), clientId);

        return ResponseEntity.ok()
                .header("Location", location)
                .body("Client registered successfully");
    }

    /**
     * Retrieves a client by its unique identifier.
     *
     * @param id the unique identifier of the client to be retrieved
     * @return a {@link ResponseEntity} containing the client details
     */
    @GetMapping("/{id}")
    @DefaultApiDocumentation(
            summary = "Retrieve client by ID",
            description = "Retrieves a client by its unique identifier"
    )
    public ResponseEntity<ClientDTO> getClient(
            @Parameter(description = "The unique identifier of the client", required = true)
            @PathVariable String id) {
        var client = clientService.get(id);
        return ResponseEntity.ok(ClientMapper.INSTANCE.entityToDto(client));
    }

}
