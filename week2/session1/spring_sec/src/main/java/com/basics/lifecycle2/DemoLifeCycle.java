package com.basics.lifecycle2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        Foo foo=context.getBean("fooAbc", Foo.class);
        foo.doFooSomething();
//        context.close();

    }
}
