package com.tuanbaol.spring.demo.eventpublish;

import org.springframework.context.ApplicationEvent;


public abstract class FruitEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public FruitEvent(Object source) {
        super(source);
    }
}
