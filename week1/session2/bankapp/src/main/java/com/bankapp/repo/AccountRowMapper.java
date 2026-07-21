package com.bankapp.repo;

import com.bankapp.dto.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setBalance(rs.getBigDecimal("balance"));
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        return account;
    }
}
