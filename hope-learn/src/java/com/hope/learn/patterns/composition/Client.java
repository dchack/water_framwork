package com.hope.learn.patterns.composition;

/**
 * Created by hope on 2018/3/9.
 */
public class Client {

    public static void main(String[] args) {
        Component composite = new Composite("Composite");
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        composite.add(leaf1);
        composite.add(leaf2);

        composite.display();
    }
}
