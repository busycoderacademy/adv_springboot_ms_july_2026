package com.basics.injection_ex;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component(value = "barBean")
@Scope("prototype")
public class Bar {

    private String localDateTimeString=LocalDateTime.now().toString();

    public String getTime(){
        System.out.println("---------");
        return localDateTimeString;
    }
}
