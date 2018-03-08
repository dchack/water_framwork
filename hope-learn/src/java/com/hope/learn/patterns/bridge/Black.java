package com.hope.learn.patterns.bridge;

/**
 * Created by hope on 2018/3/7.
 */
public class Black implements Color {
    @Override
    public void applyColor() {
        System.out.println("black");
    }
}
