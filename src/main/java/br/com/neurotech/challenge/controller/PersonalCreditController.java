package br.com.neurotech.challenge.controller;


import br.com.neurotech.challenge.model.service.CreditService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal-credit")
@RequiredArgsConstructor
@Tag(name = "Personal Credit", description = "Endpoints for managing personal credit to neurotech clients")
public class PersonalCreditController {

    private final CreditService creditService;



}
