package com.bankapp.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundTransferredEvent {
    private int fromAccountId;
    private int toAccountId;
    private BigDecimal amount;
    private LocalDateTime transferTime;

    public FundTransferredEvent(int fromId, int toId, BigDecimal amount) {
        this.fromAccountId = fromId;
        this.toAccountId = toId;
        this.amount = amount;
        this.transferTime = LocalDateTime.now();
    }
}
