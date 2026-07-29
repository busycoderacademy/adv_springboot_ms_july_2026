package com.bankapp.events;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FundTransferEvent {
    private int fromAccount;
    private int toAccount;
    private BigDecimal amount;
    private LocalDateTime transferTime;

}