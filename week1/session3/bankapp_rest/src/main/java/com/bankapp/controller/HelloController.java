package com.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    //http://localhost:8090/bankapp/hello?name=raj&city=delhi
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, @RequestParam(name = "city") String city) {
        return "Hello World : "+ LocalDateTime.now().toString()+ " : " + name + " : " + city;
    }
    //http://localhost:8090/bankapp/hello2/raja/delhi
    @GetMapping("/hello2/{name}/{city}")
    public String hello2(@PathVariable String name, @PathVariable String city) {
        return "Hello World : "+ LocalDateTime.now().toString()+ " : " + name + " : " + city;
    }
}
