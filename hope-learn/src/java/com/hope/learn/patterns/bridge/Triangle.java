package com.hope.learn.patterns.bridge;

/**
 * Created by hope on 2018/3/7.
 */
public class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void apply() {
        System.out.println("triangle");
        color.applyColor();
    }

}
