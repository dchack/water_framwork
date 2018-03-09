package com.hope.learn.patterns.composition;

/**
 * Created by hope on 2018/3/9.
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Leaf display:" + name);
    }

    @Override
    public void add(Component component) {
        System.out.println("Leaf cant add");
    }

    @Override
    public void remove(Component component) {
        System.out.println("Leaf cant remove");
    }
}
