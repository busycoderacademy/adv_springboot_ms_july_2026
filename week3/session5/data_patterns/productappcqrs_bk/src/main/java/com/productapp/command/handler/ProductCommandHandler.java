package com.productapp.command.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapp.command.commands.CreateProductCommand;
import com.productapp.event.events.ProductCreatedEvent;
import com.productapp.model.OutboxEvent;
import com.productapp.model.Product;
import com.productapp.repo.OutboxRepository;
import com.productapp.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCommandHandler {
    private final ProductRepo productRepo;
    private final ObjectMapper objectMapper;
    private final OutboxRepository outboxRepository;

    @Transactional
    public Product createProduct(CreateProductCommand createProductCommand) throws JsonProcessingException {
        Product product=Product.builder()
                .name(createProductCommand.getName())
                .price(createProductCommand.getPrice())
                .build();
        Product savedProduct=productRepo.save(product);

        ProductCreatedEvent productCreatedEvent =
                new ProductCreatedEvent(savedProduct.getId(), savedProduct.getName(), savedProduct.getPrice());

        OutboxEvent outbox = OutboxEvent.builder()
                .aggregateType("Product")
                .aggregateId(String.valueOf(savedProduct.getId()))
                .type("ProductCreated")
                .payload(objectMapper.writeValueAsString(productCreatedEvent)) // ✅ JSON String
                .processed(false)
                .build();
        outboxRepository.save(outbox);

        return savedProduct;
    }
}
