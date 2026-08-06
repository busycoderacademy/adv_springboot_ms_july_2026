package com.busycoder.accounts.servies;

import com.busycoder.accounts.dto.AccountDto;
import com.busycoder.accounts.dto.AccountInfoDto;
import com.busycoder.accounts.dto.CardDto;
import com.busycoder.accounts.dto.LoanDto;
import com.busycoder.accounts.entities.Account;
import com.busycoder.accounts.repo.AccountRepo;
import com.busycoder.accounts.serviceproxy.CardServiceProxy;
import com.busycoder.accounts.serviceproxy.LoanServiceProxy;
import com.busycoder.accounts.util.DtoConvertor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepo accountRepo;
    //use feine client
    private final LoanServiceProxy loanServiceProxy;
    private final CardServiceProxy cardServiceProxy;



    @Override
    public List<AccountDto> getAll() {
        return accountRepo.findAll().stream()
                .map(DtoConvertor::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getByMobile(String mobile) {
        return DtoConvertor.entityToDto(accountRepo.findByMobile(mobile));
    }

    @Override
    public AccountInfoDto getAccountDetails(String mobile) {
        LoanDto loanDto = loanServiceProxy.findByMobileNumber(mobile);
        CardDto cardDto = cardServiceProxy.findByMobileNumber(mobile);

        AccountInfoDto accountInfoDto=new AccountInfoDto();
        accountInfoDto.setAccountDto(getByMobile(mobile));
        accountInfoDto.setLoanDto(loanDto);
        accountInfoDto.setCardDto(cardDto);

        return accountInfoDto;
    }

    @Override
    public String addAccount(AccountDto accountDto) {
        Account account=DtoConvertor.dtoToEntity(accountDto);
        accountRepo.save(account);
        accountDto.setAccId(account.getAccId());
        return "account is added successfully";
    }
}
