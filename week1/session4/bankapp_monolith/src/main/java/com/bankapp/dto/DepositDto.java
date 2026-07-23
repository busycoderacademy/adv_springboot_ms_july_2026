package com.bankapp.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DepositDto {
    private Integer id;
    private BigDecimal amount;
}
