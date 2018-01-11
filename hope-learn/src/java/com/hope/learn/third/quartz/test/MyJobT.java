package com.hope.learn.third.quartz.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by dongchao on 2018/1/3.
 */
public class MyJobT implements org.quartz.Job {
    public MyJobT() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.err.println("Hello World!  MyJobT is executing.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
