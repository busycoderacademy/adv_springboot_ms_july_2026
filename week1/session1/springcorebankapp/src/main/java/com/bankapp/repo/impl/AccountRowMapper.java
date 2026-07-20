package com.bankapp.repo.impl;

import com.bankapp.dto.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Nullable
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setBalance(rs.getBigDecimal("balance"));
        account.setName(rs.getString("name"));

        return account;
    }
}
