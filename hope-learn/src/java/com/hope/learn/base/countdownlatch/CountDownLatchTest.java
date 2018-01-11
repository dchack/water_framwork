package com.hope.learn.base.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dongchao on 2018/1/11.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(5);

        // 依次创建并启动5个worker线程
        for (int i = 0; i < 5; ++i) {
            new Thread(
                    () -> {
                        try {
                            System.out.println("Working now ...");
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            // 简易将这个操作始终放入finally中执行
                            doneSignal.countDown(); // 当前worker执行完毕，释放一个完成信号
                        }
                    }
             ).start();
        }

        doneSignal.await();

        System.out.println("Finished.");
    }
}
