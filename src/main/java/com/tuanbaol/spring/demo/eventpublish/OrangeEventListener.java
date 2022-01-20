package com.tuanbaol.spring.demo.eventpublish;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class OrangeEventListener implements FruitEventListener {

    @Override
    public void onGet(FruitGetEvent event) {
        System.out.println("orange get");
    }

    @Override
    public void onLost(FruitLostEvent event) {
        System.out.println("orange lost");
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
