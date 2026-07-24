package com.basics.lifecycle;

public class Foo {
    private String name;
    //getter setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void doFooSomething(){
        System.out.println("Do foo something: "+ name);
    }
}
