package com.hope.learn.patterns.memento;

/**
 * Created by hope on 2018/3/11.
 */
public class Memento {

    private int state;

    public Memento(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
