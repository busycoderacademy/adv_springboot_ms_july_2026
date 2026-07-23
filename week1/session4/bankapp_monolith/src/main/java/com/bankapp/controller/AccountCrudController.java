package com.bankapp.controller;

import com.bankapp.dto.AccountDto;
import com.bankapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AccountCrudController {
    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    //get all accounts
    @GetMapping(path = "accounts" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<List<AccountDto>> getAll(){
        if(1==1){
            throw new RuntimeException("db failed");
        }
        return ResponseEntity.ok(accountService.findAll());
    }

    //get account by id
    @GetMapping(path = "accounts/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable int id){
        //if account is not found create a error response and write with response entity and return

        return ResponseEntity.ok(accountService.findById(id));
    }
    //ResponseEntity: bag that hold 2 things data + http status code
    //create acccount
    @PostMapping(path = "accounts")
    public ResponseEntity<String> create( @Valid  @RequestBody AccountDto accountDto) {
        accountService.create(accountDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("account is created sucessfully "+ accountDto.getId());
    }
    //delete account
    @DeleteMapping(path = "accounts/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        accountService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //update account


}
