package com.basics.gof.structural.a.facade.service;

public class FraudService {
    public boolean validate(int from, int to, double amount) {
        System.out.println("Validating fraud for " + amount + " transfer...");
        return amount < 100000; // simple rule
    }
}