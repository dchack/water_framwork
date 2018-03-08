package com.hope.learn.patterns.bridge;

/**
 * Created by hope on 2018/3/7.
 */
public class Pentagon extends Shape {
    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void apply() {
        System.out.println("Pentagon");
        color.applyColor();
    }
}
