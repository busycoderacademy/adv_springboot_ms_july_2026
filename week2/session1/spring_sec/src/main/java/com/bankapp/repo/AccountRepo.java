package com.bankapp.repo;

import com.bankapp.entities.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
//java reflection:
@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
    public List<Account> findByBalanceGreaterThan(BigDecimal balance);
//    public List<Account> findByBalanceLessThan(BigDecimal balance);

    @Query("select a from Account a where a.balance > ?1")
    public List<Account> getAccountOnCondition(BigDecimal balance);
}
