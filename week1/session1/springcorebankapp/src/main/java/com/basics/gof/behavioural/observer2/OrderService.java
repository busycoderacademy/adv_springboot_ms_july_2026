package com.basics.gof.behavioural.observer2;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


public class OrderService {

//    private ApplicationEventPublisher publisher;
//
//    public OrderService(ApplicationEventPublisher publisher) {
//        this.publisher = publisher;
//    }

    public void placeOrder() {

        System.out.println("Order Booked");

       //publish event

    }
}