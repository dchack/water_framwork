package com.hope.learn.base.serializable;

import java.io.*;

/**
 * Created by dongchao on 2018/1/29.
 */
public class WriteReadTest {

    public static void main(String[] args){
        Person person = new Person();
        person.setAge(25);
        person.setName("YXY");
        person.setType("not"); //modify the static value
        Person sPerson = writerThenRead(person);
        System.out.println(sPerson.getAge());//25
        System.out.println(sPerson.getType());//not
    }

    public static Person writerThenRead(Person person) {
        //serialize
        File file = new File("/Users/dongchao/dc_file/test.txt");
        try {
            OutputStream out = new FileOutputStream(file);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            objout.writeObject(person);
            objout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        person.setType("yes"); //modify the static value
        //deserializ
        Person perobj = null;
        try {
            InputStream in = new FileInputStream(file);
            ObjectInputStream objin = new ObjectInputStream(in);
            perobj = (Person)objin.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return perobj;
    }

}
