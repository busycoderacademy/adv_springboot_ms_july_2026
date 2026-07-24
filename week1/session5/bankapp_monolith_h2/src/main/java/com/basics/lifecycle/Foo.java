package com.basics.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("singleton")
@Component(value = "fooBean")
public class Foo implements BeanNameAware {
    @Value("foo name value")
    private String name;
    //getter setter

    public Foo() {
        System.out.println("Foo constructor");
    }
    //post construct
    //something should happen before init
    @PostConstruct
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

    //pre destroy
    @PreDestroy
    public void destroy() {
        System.out.println(" @PreDestroy Foo destroy");
    }

    @Override
    public void setBeanName(String name) {
        //used for logging purpose
        System.out.println("---name of the bean: "+ name);
    }
}
