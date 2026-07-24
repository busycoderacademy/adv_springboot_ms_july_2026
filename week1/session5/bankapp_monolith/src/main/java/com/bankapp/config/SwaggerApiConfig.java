package com.bankapp.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerApiConfig {

    @Bean
    public OpenAPI bankServiceAPI() {
        return new OpenAPI()
                .info(new Info().title("Bank Service API Busycoder")
                        .description("This is the REST API for Bank Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("You can refer to the Bank Service Wiki Documentation")
                        .url("https://bank-service-dummy-url.com/docs"));
    }

}
