package com.hope.learn.patterns.bridge;

/**
 * Created by hope on 2018/3/7.
 */
public abstract class Shape {

    public Color color;

    public Shape(Color color){
        this.color = color;
    }

    abstract public void apply();
}
