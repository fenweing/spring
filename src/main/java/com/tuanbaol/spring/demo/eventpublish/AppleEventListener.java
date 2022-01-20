package com.tuanbaol.spring.demo.eventpublish;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class AppleEventListener implements FruitEventListener {

    @Override
    public void onGet(FruitGetEvent event) {
        System.out.println("apple get");
    }

    @Override
    public void onLost(FruitLostEvent event) {
        System.out.println("apple lost");
    }
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof FruitGetEvent) {
            onGet((FruitGetEvent) event);
        } else if (event instanceof FruitLostEvent) {
            onLost((FruitLostEvent) event);
        }
    }
}
