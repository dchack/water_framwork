package com.hope.learn.third.quartz.base.overlap;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by hope on 2018/1/4.
 * 这个例子希望解决实际开发中的一个问题：
 * 就是相同任务重叠执行的情况，希望外界有一个开关可以控制某个任务是否允许出现任务执行的重叠。
 */
public class QuartzTest {
    public static void main(String[] args) throws InterruptedException {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            // define the job and tie it to our HelloJob class
            JobDetail job = JobBuilder.newJob(DisallowConcurrentExecutionTestJob.class)
                    .withIdentity("job1")
                    .build();
            JobDetail jobA = JobBuilder.newJob(DisallowConcurrentExecutionTestJob.class)
                    .withIdentity("joba")
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();
            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(jobA, trigger);
            scheduler.scheduleJob(job, trigger2);
//            scheduler.scheduleJob(job2, trigger2);
            // wait trigger
            Thread.sleep(20000);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
