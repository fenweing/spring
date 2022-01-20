package com.tuanbaol.spring.demo.eventpublish;


public class FruitGetEvent extends FruitEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public FruitGetEvent(Object source) {
        super(source);
    }
}
