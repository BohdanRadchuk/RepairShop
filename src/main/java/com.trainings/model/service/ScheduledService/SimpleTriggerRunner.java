package com.trainings.model.service.ScheduledService;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerRunner {

   public void startScheduleTask(){
        SchedulerFactory sf = new StdSchedulerFactory();
        try {
            Scheduler sched = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(ScheduledExecutor.class)
                    .withIdentity("job1", "group1")
                    .build();


            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?"))       //30 sec   "0/30 * * * * ?"      0 0 0 * * ?   -every day 0:00
                    .build();

            sched.scheduleJob(job, trigger);
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
