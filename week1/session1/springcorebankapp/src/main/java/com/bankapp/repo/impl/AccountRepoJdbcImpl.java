package com.bankapp.repo.impl;

import com.bankapp.dto.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

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

    private final DataSource dataSource;

    @Autowired
    public AccountRepoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Account> getAll() {

        String sql = "SELECT * FROM account";
        List<Account> accounts = new ArrayList<>();
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setBalance(rs.getBigDecimal("balance"));

                accounts.add(account);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounts;
    }

    @Override
    public Account getAccountById(int id) {

        String sql = "SELECT * FROM account WHERE id=?";

        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Account account = new Account();

                    account.setId(rs.getInt("id"));
                    account.setName(rs.getString("name"));
                    account.setBalance(rs.getBigDecimal("balance"));

                    return account;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void update(Account account) {

        String sql = "UPDATE account SET balance=? WHERE id=?";

        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setBigDecimal(1, account.getBalance());
            ps.setInt(2, account.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}