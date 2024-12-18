package br.com.neurotech.challenge.controller.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successfully processed request.",
                        content = @Content(schema = @Schema())
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad Request.",
                        content = @Content(schema = @Schema(
                                defaultValue = "Invalid input or missing parameters."))
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content = @Content(schema = @Schema(defaultValue =
                                "An unexpected error occurred. Please try again later."))

                )
        }
)
public @interface DefaultApiDocumentation {
    String summary() default "";

    String description() default "";

    Class<?> response() default Void.class;
}