package com.hope.learn.patterns.composition;

/**
 * Created by hope on 2018/3/9.
 */
public abstract class Component {

    protected String name;

    public String getName() {
        return name;
    }

    public Component(String name) {
        this.name = name;
    }

    public abstract void display();

    public abstract void add(Component component);

    public abstract void remove(Component component);
}
