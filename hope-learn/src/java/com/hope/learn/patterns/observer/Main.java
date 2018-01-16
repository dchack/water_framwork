package com.hope.learn.patterns.observer;

/**
 * Created by hope on 16/7/22.
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new OrderStatusSubject();
        subject.register(new ObserviceA());
        subject.register(new ObserviceB());
        Event event = new Event();
        event.setOrderStatus(10);
        subject.notifyObservers(event);
    }
}
