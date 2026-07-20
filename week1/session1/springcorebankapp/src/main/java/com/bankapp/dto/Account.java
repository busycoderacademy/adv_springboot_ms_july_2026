package com.bankapp.dto;

import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Account {
    private int id;
    private String name;
    private BigDecimal balance;
}
