package com.aop_basics.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //proxy is viisble with naked eye, and we write it
        //it should be dynamic proxy and not visible to us
        //AOP is dynamic proxy: aspectJ + Spring framewokr glue
        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppConfig.class);
        Magician magician=(Magician)ctx.getBean("magician");

        magician.doMagic();
        magician.doEat();
    }
}
