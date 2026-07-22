package com.bankapp.repo.impl;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountRepoJpaImpl implements AccountRepo {

    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Account> findAll() {
        return em.createQuery("select a from Account a", Account.class)
                .getResultList();
    }

    @Override
    public Account findById(int id) {
        return em.find(Account.class, id);
    }

    @Override
    public Account update(Account account) {
        em.merge(account);
        return account;
    }

    @Override
    public Account save(Account account) {
        em.persist(account);
        return account;
    }
}
