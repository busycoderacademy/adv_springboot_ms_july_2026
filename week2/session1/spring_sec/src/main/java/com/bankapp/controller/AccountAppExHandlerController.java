package com.bankapp.controller;

import com.bankapp.dto.ErrorInfoDto;
import com.bankapp.exceptions.BankAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice // under the hood it use throws advice of aop
public class AccountAppExHandlerController {
    //whenever AccountNotFoundException is thrown the control should transfer tho
    //this method
    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<ErrorInfoDto> handleBankAccountNotFoundEx(BankAccountNotFoundException ex){
        ErrorInfoDto errorInfoDto=ErrorInfoDto
        .builder().
                timestamp(LocalDateTime.now().toString()).
                status(HttpStatus.NOT_FOUND.value()).
                error(ex.getMessage()).
                path("/api/v1/accounts").
                toContact("contact@bankapp.com").
                build();

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfoDto);
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ErrorInfoDto> handle500Ex(RuntimeException ex){
//        ErrorInfoDto errorInfoDto=ErrorInfoDto
//                .builder().
//                timestamp(LocalDateTime.now().toString()).
//                status(HttpStatus.INTERNAL_SERVER_ERROR.value()).
//                error("Pls try after some time").
//                path("/api/v1/accounts").
//                toContact("contact@bankapp.com").
//                build();
//
//        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfoDto);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfoDto> handle400Ex(MethodArgumentNotValidException ex){
        String errorMessage=ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(e-> e.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorInfoDto errorInfoDto=ErrorInfoDto
                .builder().
                timestamp(LocalDateTime.now().toString()).
                status(HttpStatus.BAD_REQUEST.value()).
                error(errorMessage).
                path("/api/v1/accounts").
                toContact("contact@bankapp.com").
                build();

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfoDto);
    }

}
