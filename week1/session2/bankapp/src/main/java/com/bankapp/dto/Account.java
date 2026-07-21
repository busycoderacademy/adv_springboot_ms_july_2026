package com.bankapp.dto;

import lombok.*;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Account {
    private int id;
    private String name;
    private BigDecimal balance;
}
