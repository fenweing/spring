package com.tuanbaol.spring.demo.eventpublish;

import org.springframework.context.ApplicationListener;

public interface FruitEventListener extends ApplicationListener {
    void onGet(FruitGetEvent event);

    void onLost(FruitLostEvent event);

}
