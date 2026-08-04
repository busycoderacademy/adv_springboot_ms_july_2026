package com.busycoder.resilency.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RateLimiterController {

    @GetMapping("bankdemo")
    @RateLimiter(name = "helloControllerLimiter")
    public String helloController(){
        return  "hello controller "+ LocalDateTime.now().toString();
    }
}
