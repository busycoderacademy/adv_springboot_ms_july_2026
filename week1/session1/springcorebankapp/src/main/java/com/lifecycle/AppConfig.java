package com.lifecycle;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.lifecycle")
public class AppConfig {
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public Foo foo() {
        return new Foo();
    }
}
