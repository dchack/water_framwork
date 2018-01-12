package com.hope.learn.third.quartz.base.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Created by hope on 2018/1/12.
 * JOB触发时的监听器
 */
public class JobListenerTest implements JobListener {
    @Override
    public String getName() {
        return "JobListenerTest";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println(context.getJobDetail().getKey().getName()+":A");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println(context.getJobDetail().getKey().getName()+":B");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println(context.getJobDetail().getKey().getName()+":C");
    }
}
