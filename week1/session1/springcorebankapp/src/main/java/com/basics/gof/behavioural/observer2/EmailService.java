package com.basics.gof.behavioural.observer2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class EmailService {
    public void sendEmail(OrderCreatedEvent event) {
        System.out.println("Confirmation Email Sent");
    }
}