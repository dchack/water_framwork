package com.hope.learn.third.quartz.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by dongchao on 2018/1/3.
 */
public class MyJob implements org.quartz.Job {
    public MyJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("Hello World!  MyJob is executing.");
    }
}
