package com.busycoder.resilency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    @GetMapping("/slow")
    public String slow() throws Exception {
        System.out.println("Card Service Started : " + Thread.currentThread().getName());
        Thread.sleep(15000);
        System.out.println("Card Service Completed : " + Thread.currentThread().getName());
        return "Card Service Response";
    }
}
