package com.bankapp.repo.impl;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
//@Profile("test")
public class AccountRepoJdbcImpl implements AccountRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> getAll() {
        return jdbcTemplate.query("select * from account", new AccountRowMapper());
    }

    @Override
    public Account getById(int id) {
        String sql = "SELECT * FROM account WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new AccountRowMapper());
    }

    @Override
    public void update(Account account) {
        String sql = "UPDATE account SET balance=? WHERE id=?";
        jdbcTemplate.update(sql, new Object[]{account.getBalance(), account.getId()});
    }
}
