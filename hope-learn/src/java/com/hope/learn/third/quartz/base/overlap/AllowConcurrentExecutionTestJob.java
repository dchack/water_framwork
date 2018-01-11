package com.hope.learn.third.quartz.base.overlap;

import org.quartz.*;

import java.util.List;

/**
 * Created by hope on 2018/1/3.
 */
public class AllowConcurrentExecutionTestJob implements Job {
    public AllowConcurrentExecutionTestJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        try {
            List<JobExecutionContext> list = context.getScheduler().getCurrentlyExecutingJobs();
            for(JobExecutionContext jobExecutionContext : list){
                // job内部获取容器内变量
                System.out.println(jobExecutionContext.getJobDetail().getKey().getName());
            }
            Thread.sleep(4000);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!  AllowConcurrentExecutionTestJob is executing.");
    }
}
