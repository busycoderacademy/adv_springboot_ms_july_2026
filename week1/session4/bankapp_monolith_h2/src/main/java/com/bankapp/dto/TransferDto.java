package com.bankapp.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TransferDto {
    private Integer fromAccountId;
    private Integer toAccountId;
    private BigDecimal amount;
}
