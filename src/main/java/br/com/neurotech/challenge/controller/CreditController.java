package br.com.neurotech.challenge.controller;


import br.com.neurotech.challenge.controller.annotation.DefaultApiDocumentation;
import br.com.neurotech.challenge.controller.dto.EligibleClientDTO;
import br.com.neurotech.challenge.controller.mapper.ClientMapper;
import br.com.neurotech.challenge.model.entity.enums.VehicleModel;
import br.com.neurotech.challenge.model.service.CreditService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eligible-credit")
@RequiredArgsConstructor
@Tag(name = "Credit", description = "Endpoints for managing personal credit to neurotech clients")
public class CreditController {

    private final CreditService creditService;

    /**
     * Check the credit eligibility of a client for a specific vehicle model
     *
     * @param clientId The unique identifier of the client
     * @param model    The vehicle model to check credit eligibility for
     * @return A {@link ResponseEntity} containing a {@link Boolean} value indicating if the client is eligible for credit.
     */
    @GetMapping
    @DefaultApiDocumentation(
            summary = "Check Credit Eligibility",
            description = "Checks if a client is eligible for credit for a specific vehicle model based on the provided client ID and vehicle model."
    )
    public ResponseEntity<Boolean> checkCredit(
            @Parameter(description = "The unique identifier of the client", required = true)
            @RequestParam Long clientId,
            @Parameter(description = "The vehicle model for which credit eligibility is being checked", required = true)
            @RequestParam VehicleModel model) {

        var isEligible = creditService.checkCredit(clientId, model);
        return ResponseEntity.ok().body(isEligible);
    }

    @GetMapping("/hatch")
    @DefaultApiDocumentation(
            summary = "Retrieve clients eligible for Hatch vehicle",
            description = "Provides a list of clients aged between 23 and 49 years who have Fixed Interest Credit and qualify for Hatch vehicle."
    )
    public ResponseEntity<List<EligibleClientDTO>> retrieveClientsEligibleForHatch() {
        var clientList = creditService.getAllClientsEligibleForHatch();
        return ResponseEntity.ok().body(ClientMapper.INSTANCE.entityToDtoList(clientList));
    }

}
