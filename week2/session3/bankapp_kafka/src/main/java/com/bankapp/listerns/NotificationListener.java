package com.bankapp.listerns;

import com.bankapp.events.FundTransferEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class NotificationListener {
    @Order(1)
    @EventListener
    public void listen(FundTransferEvent fundTransferEvent) {
        System.out.println("--------------------------------------------------");
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Fund Transfer Event Received: NotificationListener" + fundTransferEvent);
    }
}
