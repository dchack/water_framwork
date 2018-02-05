package com.hope.learn.base.countdownlatch;

import org.junit.Assert;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dongchao on 2018/1/11.
 */
public class Test {

    @org.junit.Test
    public void test() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(3);


        boolean s = true;
        //get from duplicate thread
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Assert.assertTrue("serveral Deserializer!", true);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("i");
//                    countDownLatch.countDown();
                }
            }).start();
        }

        System.out.printf("222");
//                countDownLatch.await();

    }
}
