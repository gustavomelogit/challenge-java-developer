package br.com.neurotech.challenge.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Represents the client")
public class ClientDTO {
    
    @Schema(description = "The name of the client", example = "Bob")
    private String name;

    @Schema(description = "The age of the client", example = "40")
    private Integer age;

    @Schema(description = "The income of the client in monetary value", example = "10000.00")
    private Double income;

}
