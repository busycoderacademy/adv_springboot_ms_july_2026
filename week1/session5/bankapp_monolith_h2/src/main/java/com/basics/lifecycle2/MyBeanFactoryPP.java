package com.basics.lifecycle2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

public class MyBeanFactoryPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //if u want to modify the bean definitions before they are created ?
        //modify the bean definitions

        System.out.println("--- BeanFactoryPostProcessor: postProcessBeanFactory is called");
        BeanDefinition bd =
                beanFactory.getBeanDefinition("fooBean");

        bd.setScope("prototype");
    }
}
