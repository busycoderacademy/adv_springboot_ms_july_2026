package com.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "bank")
public class BankDtoConfig {
    private String name;
    private String branch;
    private String location;
    private String address;
    private String phone;
    private String email;
}