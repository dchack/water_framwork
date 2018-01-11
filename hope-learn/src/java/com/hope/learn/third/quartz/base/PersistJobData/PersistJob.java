package com.hope.learn.third.quartz.base.PersistJobData;

import org.quartz.*;

/**
 * Created by dongchao on 2018/1/6.
 */
@PersistJobDataAfterExecution
public class PersistJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getJobDetail().getJobDataMap();
        int i = data.getInt("P");
        System.out.printf("PersistJob=>"+i);
        i++;
        data.put("P", i);
    }
}
