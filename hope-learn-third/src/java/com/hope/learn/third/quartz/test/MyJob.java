package com.hope.learn.third.quartz.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * Created by dongchao on 2018/1/3.
 */
public class MyJob implements org.quartz.Job {
    public MyJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        try {
            List<JobExecutionContext> list = context.getScheduler().getCurrentlyExecutingJobs();
            for(JobExecutionContext jobExecutionContext : list){
                // job内部获取容器内变量
                System.out.printf(jobExecutionContext.getJobDetail().getKey().getGroup());
            }
            Thread.sleep(5000);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("Hello World!  MyJob is executing.");
    }
}
