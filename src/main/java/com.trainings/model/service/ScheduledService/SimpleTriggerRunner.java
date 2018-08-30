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
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))       //30 sec   "0/30 * * * * ?")      0 0 0 * * ?   -every day 0:00
                    .build();

            sched.scheduleJob(job, trigger);
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


        /*  try {
            JobDetail job = JobBuilder.newJob(ScheduledExecutor.class).withIdentity("myjob").build();

            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(30).repeatForever()).build();

            SchedulerFactory schFactory = new StdSchedulerFactory();
            Scheduler scheduler = schFactory.getScheduler();

            scheduler.start();
            scheduler.scheduleJob(job, trigger);


            CronTrigger cronTrigger = newTrigger
                    new CronTrigger("cronTrigger", "triggerGroup2");
            try {
                // Устанавливаем CronExpression
                CronExpression cexp = new CronExpression("0/5 * * * * ?");
                // Присваиваем CronExpression CronTrigger'у
                cronTrigger.setCronExpression(cexp);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }catch (SchedulerException e) {

            e.printStackTrace();
        }*/
    }
}
