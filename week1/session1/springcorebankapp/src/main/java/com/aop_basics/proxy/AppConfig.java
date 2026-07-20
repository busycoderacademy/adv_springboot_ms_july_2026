package com.aop_basics.proxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop_basics.proxy")
@EnableAspectJAutoProxy
public class AppConfig {
}
