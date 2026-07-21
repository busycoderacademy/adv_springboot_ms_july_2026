package com.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    }
}
