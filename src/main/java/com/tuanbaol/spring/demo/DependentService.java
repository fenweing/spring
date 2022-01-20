package com.tuanbaol.spring.demo;

import com.tuanbaol.spring.demo.InitialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DependentService implements DisposableBean {
    @Autowired
    public DependentService(InitialService initialService) {
    }

    @Override
    public void destroy() throws Exception {
        log.info("-->destroy,DependentService");
    }
}
