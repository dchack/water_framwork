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
        Person.TYPE="no"; //modify the static value

        File file = new File("/test.txt");
        try {
            OutputStream out = new FileOutputStream(file);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            objout.writeObject(person);
            objout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //deserializ
        Person perobj = null;
        try {
            InputStream in = new FileInputStream(file);
            ObjectInputStream objin = new ObjectInputStream(in);
            perobj = (Person)objin.readObject();
            System.out.println(perobj.TYPE);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
