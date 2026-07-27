package com.bankapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "account_table")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_accountHolderName")
    private String accountHolderName;

    @Column(name = "account_balance")
    private BigDecimal balance;

    private String email;
    private String phone;


    public Account(String accountHolderName, BigDecimal balance, String email, String phone) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phone = phone;
    }
}
