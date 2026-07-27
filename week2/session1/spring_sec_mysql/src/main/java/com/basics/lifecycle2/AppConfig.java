package com.basics.lifecycle2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.basics.lifecycle")
public class AppConfig {

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Foo fooAbc() {
      Foo foo = new Foo();
      foo.setName("foo name value");
      return foo;
    }
    //define bean for MyBeanPP
    @Bean
    public static MyBeanPP myBeanPP() {
      return new MyBeanPP();
    }
    //define bean for MyBeanFactoryPP
    @Bean
    public static MyBeanFactoryPP myBeanFactoryPP() {
      return new MyBeanFactoryPP();
    }

}
