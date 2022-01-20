package com.tuanbaol.spring.demo.beanfactory;

import lombok.Data;

import static org.junit.Assert.*;

import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Service
@Listable.Anno("of")
public class Listable implements ApplicationRunner, ApplicationContextAware {

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("in listable...");
        assertEquals(applicationContext.getBeanNamesForAnnotation(Anno.class), new String[]{"listable"});
        assertEquals(applicationContext.findAnnotationOnBean("listable", Anno.class).value(), "of");
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Anno {
        String value();
    }
}
