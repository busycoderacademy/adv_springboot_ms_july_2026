package com.productapp.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfig {
    private String message;
    private String featureEnabled;
}
