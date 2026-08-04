package com.productapp.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "database")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbConfig {
    private String username;
    private String password;

}
