package com.bankapp.repo.impl;

import com.bankapp.dto.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class AccountRepoJdbcImpl implements AccountRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountRepoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> getAll() {
        return jdbcTemplate.query("select * from account", new AccountRowMapper());
    }

    @Override
    public Account getAccountById(int id) {
        String sql = "SELECT * FROM account WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new AccountRowMapper());
    }

    @Override
    public void update(Account account) {
        String sql = "UPDATE account SET balance=? WHERE id=?";
        jdbcTemplate.update(sql, new Object[]{account.getBalance(), account.getId()});
    }
}