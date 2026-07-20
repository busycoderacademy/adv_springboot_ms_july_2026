package com.basics.gof.behavioural.observer2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class InventoryService {
    public void updateInventory(OrderCreatedEvent event) {
        System.out.println("Inventory Updated");
    }
}