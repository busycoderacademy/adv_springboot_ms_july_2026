package com.basics.lifecycle2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Foo  {

    private String name;
    //getter setter

    public Foo() {
        System.out.println("Foo constructor");
    }

    public void init() {
        System.out.println(" @PostConstruct Foo init");
    }
        //something should happen after init

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void doFooSomething(){
        System.out.println("Do foo something: "+ name);
    }


    public void destroy() {
        System.out.println(" @PreDestroy Foo destroy");
    }


}
