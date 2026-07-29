package com.bankapp.listerns;

import com.bankapp.events.FundTransferEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationListener{
    @Order(2)
    @EventListener
    public void listen(FundTransferEvent fundTransferEvent) {
        System.out.println("--------------------------------------------------");
        System.out.println("Fund Transfer Event Received: EmailNotificationListener " + fundTransferEvent);
    }
}
