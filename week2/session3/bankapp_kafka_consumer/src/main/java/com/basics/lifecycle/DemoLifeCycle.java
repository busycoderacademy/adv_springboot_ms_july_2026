package com.basics.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        Foo foo=context.getBean("fooBean", Foo.class);

        Foo foo2=context.getBean("fooBean", Foo.class);

        System.out.println("--- foo == foo2: " + (foo == foo2));
        foo.doFooSomething();
//        context.close();

    }
}
