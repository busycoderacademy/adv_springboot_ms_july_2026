package com.busycoder.resilency.controller;

import com.busycoder.resilency.dto.AccountDto;
import com.busycoder.resilency.dto.AccountInfoDto;
import com.busycoder.resilency.dto.InfoDto;
import com.busycoder.resilency.servies.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "api")
@RestController
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final InfoDto appInfoDto;


    @GetMapping("contact-info")
    public InfoDto appInfo(){
        return   appInfoDto;
    }

    @GetMapping("fetchall")
    public List<AccountDto> getAll(){
        return   accountService.getAll();
    }

    @GetMapping("fetch")
    public AccountDto getByMobile(@RequestParam(name="mobile") String mobile){
      return   accountService.getByMobile(mobile);
    }
	
    @GetMapping("accountsdetails")
    public AccountInfoDto getAccountDetails(@RequestParam(name = "mobile") String mobile){
        return accountService.getAccountDetails(mobile);
    }
    @PostMapping(path = "add")
    public String addAccount(@RequestBody AccountDto accountDto){
        return accountService.addAccount(accountDto);
    }
}
