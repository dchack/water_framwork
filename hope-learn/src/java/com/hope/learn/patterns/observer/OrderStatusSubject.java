package com.hope.learn.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hope on 16/7/22.
 */
public class OrderStatusSubject implements Subject {

    private List<Observer> observers;

    public OrderStatusSubject() {
        this.observers = new ArrayList<Observer>();
    }


    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        if(!observers.contains(obj)) observers.add(obj);

    }

    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    public void notifyObservers(Event event) {
        for (Observer observer : observers){
            observer.execute(event);
        }
    }
}
