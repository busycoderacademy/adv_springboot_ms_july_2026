package com.basics.gof.behavioural.observer2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShipmentService {

    @EventListener
    public void createShipment(OrderCreatedEvent event) {

        System.out.println("Shipment Created for Order "
                + event.getOrderId());
    }
}