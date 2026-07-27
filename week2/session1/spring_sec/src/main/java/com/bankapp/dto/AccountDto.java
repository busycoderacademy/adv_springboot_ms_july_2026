package com.bankapp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDto {
    private int id;

    @NotNull(message = "{accountDto.accountHolderName.absent}")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{accountDto.accountHolderName.invalid}")
    private String accountHolderName;

    @NotNull(message = "{accountDto.balance.absent}")
    @Range(min = 100, max = 100000, message = "{accountDto.balance.invalid}")
    private BigDecimal balance;

    private String email;
    private String phone;

    public AccountDto(String accountHolderName, BigDecimal balance, String email, String phone) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phone = phone;
    }
}
