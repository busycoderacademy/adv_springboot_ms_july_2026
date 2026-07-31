package com.busycoder.resilency.repo;

import com.busycoder.resilency.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    public Account findByMobile(String mobile);
}
