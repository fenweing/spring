package com.tuanbaol.spring.demo.eventpublish;

import java.util.EventObject;

public class FruitLostEvent extends FruitEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public FruitLostEvent(Object source) {
        super(source);
    }
}
