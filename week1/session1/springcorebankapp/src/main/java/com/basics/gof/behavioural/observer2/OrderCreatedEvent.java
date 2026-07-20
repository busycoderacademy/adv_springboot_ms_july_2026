package com.basics.gof.behavioural.observer2;

public class OrderCreatedEvent {

    private int orderId;

    public OrderCreatedEvent(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}