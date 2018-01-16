package com.hope.learn.patterns.observer;

/**
 * Created by hope on 16/7/22.
 */
public class ObserviceA implements Observer{
    public boolean execute(Event event) {
        System.out.println("Observice A =>"+event.getOrderStatus());
        return false;
    }
}
