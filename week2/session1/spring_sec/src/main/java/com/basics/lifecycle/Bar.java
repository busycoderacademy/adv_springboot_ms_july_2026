package com.basics.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "barBean")
@Scope("singleton")
//@Lazy(value = true)
public class Bar {
    @Value("bar name value")
    private String name;
    //getter setter

    public Bar() {
        System.out.println("Bar constructor");
    }
    //post construct
    @PostConstruct
    public void init() {
        System.out.println(" @PostConstruct Bar init");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void doFooSomething(){
        System.out.println("Do bar something: "+ name);
    }

    //pre destroy
    @PreDestroy
    public void destroy() {
        System.out.println(" @PreDestroy Bar destroy");
    }


}
