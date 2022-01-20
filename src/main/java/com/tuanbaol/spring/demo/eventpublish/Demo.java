package com.tuanbaol.spring.demo.eventpublish;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

@Component
public class Demo implements ApplicationContextAware, ApplicationRunner {
    private WebApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(Arrays.asList(args));
        applicationContext.publishEvent(new FruitLostEvent(new Object()));
        applicationContext.publishEvent(new FruitGetEvent(new Object()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (WebApplicationContext) applicationContext;
    }
}
