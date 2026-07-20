package com.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//@ComponentScan(basePackages = "com.bankapp")
////i want to go with aop
//@EnableAspectJAutoProxy
//public class AppConfig {
//
//    //want to define drivermaangerdatasouce
//    @Bean
//    public DriverManagerDataSource driverManagerDataSource(){
//        DriverManagerDataSource dataSource=new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/bankdb");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//}
