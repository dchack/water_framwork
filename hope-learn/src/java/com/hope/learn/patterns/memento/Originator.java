package com.hope.learn.patterns.memento;

/**
 * Created by hope on 2018/3/11.
 */
public class Originator {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void show(){
        System.out.println("Originator:"+state);
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setMemento(Memento memento){
        state = memento.getState();
    }
}
