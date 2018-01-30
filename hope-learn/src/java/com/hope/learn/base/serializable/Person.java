package com.hope.learn.base.serializable;

import java.io.Serializable;

/**
 * Created by dongchao on 2018/1/29.
 */
public class Person implements Serializable{

    private static String type = "person";
    private int age;
    private String name;

    // 假设卡号这种信息不想被序列化
    private transient String cardNo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

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
