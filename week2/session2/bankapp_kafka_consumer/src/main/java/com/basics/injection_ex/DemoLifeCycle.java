package com.basics.injection_ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Foo foo=context.getBean("fooBean", Foo.class);
        foo.doSomething();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        foo.doSomething();


    }
}
