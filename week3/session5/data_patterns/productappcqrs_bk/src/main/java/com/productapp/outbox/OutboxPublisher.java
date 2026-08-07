package com.productapp.outbox;

import com.productapp.model.OutboxEvent;
import com.productapp.repo.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OutboxPublisher {

    private final OutboxRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedDelay = 5000)
    @Transactional
    public void publishEvents() {
        List<OutboxEvent> events = repository.findByProcessedFalse();
        for (OutboxEvent event : events) {
            kafkaTemplate.send(
                    "product-created-topic",
                    event.getAggregateId(),
                    event.getPayload()
            );
            event.setProcessed(true);
        }
    }
}
