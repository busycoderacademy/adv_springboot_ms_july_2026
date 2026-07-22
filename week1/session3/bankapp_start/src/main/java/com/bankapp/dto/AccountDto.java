package com.bankapp.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDto {
    private int id;
    private String accountHolderName;
    private BigDecimal balance;

    public AccountDto(String accountHolderName, BigDecimal balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
}
