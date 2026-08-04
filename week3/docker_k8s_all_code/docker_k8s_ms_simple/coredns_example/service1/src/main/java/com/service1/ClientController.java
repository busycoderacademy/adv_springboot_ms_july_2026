package com.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
class ClientController {

    @Autowired
    private  RestTemplate restTemplate;

    @Value("${service.b.url}")
    private String serviceBUrl;

    @GetMapping("/invoke")
    public String invokeServiceB() {
        return restTemplate.getForObject(serviceBUrl + "/api/hello", String.class);
    }
}