package com.basics.gof.structural.a.facade.service;

public class NotificationService {
    public void send(String message) {
        System.out.println("SMS Notification Sent: " + message);
    }
}
