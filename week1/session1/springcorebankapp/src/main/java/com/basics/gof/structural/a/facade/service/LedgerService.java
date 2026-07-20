package com.basics.gof.structural.a.facade.service;

public class LedgerService {
    public void record(int from, int to, double amount) {
        System.out.println("Ledger updated: Transfer of " + amount + " from " + from + " to " + to);
    }
}
