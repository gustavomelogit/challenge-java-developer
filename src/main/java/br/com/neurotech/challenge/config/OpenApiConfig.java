package br.com.neurotech.challenge.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class OpenApiConfig {

    @Value("${app.version}")
    String applicationVersion;

    @Bean
    public OpenAPI customOpenAPI() {
        log.info("Application version: {}", applicationVersion);

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
                        .version(applicationVersion)
                );
    }
}
