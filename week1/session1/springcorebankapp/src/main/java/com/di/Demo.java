package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);

        Passager passager = ctx.getBean("passager", Passager.class);

        passager.travel();
    }
}
