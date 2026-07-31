package com.busycoder.resilency.servies;

import com.busycoder.resilency.dto.AccountDto;
import com.busycoder.resilency.dto.AccountInfoDto;

import java.util.List;

public interface AccountService {
    public List<AccountDto> getAll();
    public AccountDto getByMobile(String mobile);
    public AccountInfoDto getAccountDetails(String mobile);
    public String addAccount(AccountDto accountDto);
}