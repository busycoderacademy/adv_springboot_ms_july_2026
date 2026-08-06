package com.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {
    //we have to define routes here
    @Value("${gateway.accounts-url}")
    private String accountsUrl;

    @Value("${gateway.cards-url}")
    private String cardsUrl;

    @Value("${gateway.loans-url}")
    private String loansUrl;

    @Bean
    public RouteLocator busycoderRouteConfig(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("accounts", r -> r
                        .path("/busycoder/accounts/**")
                        .filters(f -> f
                                .rewritePath("/busycoder/accounts/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri(accountsUrl))

                .route("cards", r -> r
                        .path("/busycoder/cards/**")
                        .filters(f -> f
                                .rewritePath("/busycoder/cards/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri(cardsUrl))

                .route("loans", r -> r
                        .path("/busycoder/loans/**")
                        .filters(f -> f
                                .rewritePath("/busycoder/loans/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri(loansUrl))

                .build();
    }
}
