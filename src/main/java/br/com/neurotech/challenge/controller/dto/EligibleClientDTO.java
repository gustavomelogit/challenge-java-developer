package br.com.neurotech.challenge.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Represents the eligible client")
public class EligibleClientDTO {

    @Schema(description = "The name of the client", example = "Bob")
    private String name;

    @Schema(description = "The income of the client in monetary value", example = "10000.00")
    private BigDecimal income;

}
