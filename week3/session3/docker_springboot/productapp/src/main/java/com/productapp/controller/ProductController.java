package com.productapp.controller;

import com.productapp.config.DbConfig;
import com.productapp.config.ProductConfig;
import com.productapp.service.InstanceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private InstanceInformationService instanceInformationService;

    @Autowired
    private DbConfig dbConfig;

    @Autowired
    private ProductConfig productConfig;

    @GetMapping("/config")
    public String config() {
        return dbConfig.toString() + "  " + productConfig.toString();
    }
    @GetMapping(path = "hello-world")
    public String hello() {
        return "hello V3 " + instanceInformationService.retrieveInstanceInfo();
    }

    @GetMapping("/cpu")
    public String cpu() {
        double result = 0;
        for(int i=0;i<100000000;i++){
            result += Math.sqrt(i);
        }
        return "CPU Load " + result;
    }
}