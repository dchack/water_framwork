package com.hope.learn.patterns.observer;

/**
 * Created by hope on 16/7/28.
 */
public class ObserviceB implements Observer{
    public boolean execute(Event event) {
        System.out.println("Observice B =>"+event.getOrderStatus());
        return false;
    }
}
