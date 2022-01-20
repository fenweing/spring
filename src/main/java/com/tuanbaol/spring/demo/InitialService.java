package com.tuanbaol.spring.demo;

import com.tuanbaol.spring.demo.beanfactory.MyBeanDefinitionRegistryPostProcessor;
import com.tuanbaol.spring.demo.beanfactory.MyBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InitialService implements InitializingBean, BeanNameAware, BeanClassLoaderAware, DisposableBean {
    @Autowired
    public InitialService(DependentService dependentService) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-->afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("-->setBeanClassLoader-{}", classLoader.getClass());
    }

    @Override
    public void setBeanName(String name) {
        log.info("-->setBeanName-{}", name);
    }

    public void initMethod() {
        log.info("-->setBeanName");
    }

    public void destroyMethod() {
        log.info("-->setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        log.info("-->destroy");
    }
}
