package com.hope.learn.patterns.observer;

/**
 * Created by hope on 16/7/22.
 */
public interface Subject {

    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers(Event event);
}
