package com.basics.injection_ex;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("singleton")
@Component(value = "fooBean")
 public class Foo{

    private Bar bar;

    //@Lookup annotation
    @Lookup
    public  Bar getBar(){
        return null;
    }

    public void doSomething(){
        System.out.println( getBar().getTime());;
        System.out.println("Do something of Foo");
    }

}
