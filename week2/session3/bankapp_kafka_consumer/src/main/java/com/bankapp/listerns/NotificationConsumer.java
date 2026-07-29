package com.bankapp.listerns;

import com.bankapp.events.FundTransferEvent;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class NotificationConsumer {

    @RetryableTopic(  attempts = "3", backoff = @Backoff(delay = 3000))
    @KafkaListener(topics = "fund-transfer-events", groupId = "notification-group")
    public void consume(FundTransferEvent event) {
        System.out.println("----------------------------------------");
        //consumer will get the event from the topic and throw a ex if amount is more then 100
        if (event.getAmount().compareTo(new BigDecimal("100")) > 0) {
            throw new RuntimeException("Amount is more than 100");
        }
        System.out.println("Received event: " + event);
    }

    @DltHandler
    public void processFailedTransfer( FundTransferEvent event){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Transfer moved to Dead Letter Topic");
        System.out.println(event);

    }
}
