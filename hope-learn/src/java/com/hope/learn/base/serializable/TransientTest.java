package com.hope.learn.base.serializable;

/**
 * Created by dongchao on 2018/1/30.
 */
public class TransientTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setCardNo("3306111111");
        Person sPerson = WriteReadTest.writerThenRead(person);
        System.out.println(sPerson.getCardNo());//null
    }
}
