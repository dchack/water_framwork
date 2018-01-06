package com.hope.learn.third.quartz.base.overlap;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dongchao on 2018/1/5.
 */
public class SelfDisAllowConExeTestJob implements org.quartz.Job{
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            List<JobExecutionContext> list = context.getScheduler().getCurrentlyExecutingJobs();
            Set<String> jobs = new HashSet<String>();
            int i=0;
            for (JobExecutionContext jobExecutionContext : list){
                if(context.getJobDetail().getKey().getName().equals(jobExecutionContext.getJobDetail().getKey().getName())){
                    i++;
                }
            }
            if(i>1){
                System.out.printf("self disallow ");
                return;
            }
            Thread.sleep(4000);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!  SelfDisAllowConExeTestJob is executing.");

    }
}
