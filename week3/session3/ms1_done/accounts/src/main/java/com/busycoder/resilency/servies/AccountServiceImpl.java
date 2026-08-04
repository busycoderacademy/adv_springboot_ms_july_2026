package com.busycoder.resilency.servies;

import com.busycoder.resilency.dto.AccountDto;
import com.busycoder.resilency.dto.AccountInfoDto;
import com.busycoder.resilency.dto.CardDto;
import com.busycoder.resilency.dto.LoanDto;
import com.busycoder.resilency.entities.Account;
import com.busycoder.resilency.repo.AccountRepo;
import com.busycoder.resilency.serviceproxy.CardServiceProxy;
import com.busycoder.resilency.serviceproxy.LoanServiceProxy;
import com.busycoder.resilency.util.DtoConvertor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepo accountRepo;
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

        //somehow we should able to call the
        // loans and cards ms and get the related inforation
        //http://localhost:8090/loans?mobile=7088993300
        LoanDto loanDto =loanServiceProxy.findByMobileNumber(mobile);
        CardDto cardDto = cardServiceProxy.findByMobileNumber(mobile);

       // http://localhost:9090/cards?mobile=7088993300

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
