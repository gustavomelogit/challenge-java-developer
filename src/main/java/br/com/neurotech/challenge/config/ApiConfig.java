package br.com.neurotech.challenge.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApiConfig {

    @Value("${api.client.base.url}")
    private String apiBaseUrl;

    @Value("${app.version}")
    String applicationVersion;

}
