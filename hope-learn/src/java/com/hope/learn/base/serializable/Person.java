package com.hope.learn.base.serializable;

/**
 * Created by dongchao on 2018/1/29.
 */
public class Person {

    public static String TYPE = "person";
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
