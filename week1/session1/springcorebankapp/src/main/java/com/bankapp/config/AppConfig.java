package com.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
//SB= spring- autoconfigration of the bean + +++++++
@Configuration
@ComponentScan(basePackages = "com.bankapp")
@EnableTransactionManagement
public class AppConfig {
    //hey spring can u create datasource for me
    @Bean //@Bean vs @Compoent
    DriverManagerDataSource driverManagerDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bankdb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    //jdbctemplate: template design patten: to avoid writing connection code again and again, boilerplate code

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    //also configure transaction manager: it support declaritive tx mgt
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
