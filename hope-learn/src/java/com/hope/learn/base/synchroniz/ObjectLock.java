package com.hope.learn.base.synchroniz;

/**
 * Created by dongchao on 2018/1/18.
 */
public class ObjectLock {
    public static void main(String[] args) {
        System.out.println("start time = " + System.currentTimeMillis()+"ms");
        LockTestClass test = new LockTestClass();
        for (int i = 0; i < 3; i++) {
            Thread thread = new ObjThread(test, i);
            thread.start();
        }
    }
}
