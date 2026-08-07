package com.productapp.projection;

import com.productapp.event.events.ProductCreatedEvent;
import com.productapp.model.ProductView;
import com.productapp.repo.ProductViewRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductProjection {
    private final ProductViewRepo productViewRepo;

    @KafkaListener(topics = "product-created-topic", groupId = "product-query-group")
    public void on(ProductCreatedEvent productCreatedEvent){
        ProductView productView=
                ProductView.builder()
                        .id(productCreatedEvent.getId())
                        .name(productCreatedEvent.getName())
                        .price(productCreatedEvent.getPrice())
                        .build();
        productViewRepo.save(productView);
    }
}
