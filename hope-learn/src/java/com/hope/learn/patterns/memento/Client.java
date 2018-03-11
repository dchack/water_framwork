package com.hope.learn.patterns.memento;

/**
 * Created by hope on 2018/3/11.
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState(1024);
        originator.show();

        Memento memento = originator.createMemento();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);

        originator.setState(2048);
        originator.show();

        originator.setMemento(caretaker.getMemento());
        originator.show();

    }
}
