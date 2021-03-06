package com.hope.learn.third.quartz.test;

import com.hope.learn.third.quartz.base.listener.JobListenerTest;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by hope on 2018/1/4.
 * 官方文档的完整例子，直接使用文档代码是编译不过的，这里整理一份
 */
public class QuartzTest {
    public static void main(String[] args) throws InterruptedException {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            // define the job and tie it to our HelloJob class
            JobDetail job = JobBuilder.newJob(MyJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(4)
                            .repeatForever())
                    .build();


            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
            //第四步：关联监听器
            JobListenerTest listener = new JobListenerTest();
            scheduler.getListenerManager().addJobListener(listener);

            // wait trigger
            Thread.sleep(10000);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
