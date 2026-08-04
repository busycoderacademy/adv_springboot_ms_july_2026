package com.busycoder.resilency.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api/orders")
@RestController
public class OrderController {

    @Autowired
    private  RestTemplate restTemplate;

    @GetMapping("/demo")
    @Bulkhead(name = "cardService")
    public String orderDemo() {
        return restTemplate.
                getForObject( "http://localhost:8085/api/cards/slow", String.class);
    }
}