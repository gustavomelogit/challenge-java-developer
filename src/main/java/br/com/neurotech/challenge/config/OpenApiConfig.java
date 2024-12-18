package br.com.neurotech.challenge.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private final ApiConfig apiConfig;

    @Bean
    public OpenAPI customOpenAPI() {
        var appVersion = apiConfig.getApplicationVersion();
        log.info("Application version: {}", appVersion);

        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("MS Personal Credit")
                        .description("""
                                Microservice for registering and consulting clients, evaluating and applying credit modalities for individuals according to specific criteria.
                               
                                The different credit modalities are:
                                - Credit with fixed interest;
                                - Credit with variable interest;
                                - Consigned credit
                                """)
                        .version(appVersion)
                );
    }
}
