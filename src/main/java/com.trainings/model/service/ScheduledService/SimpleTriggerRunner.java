package com.trainings.model.service.ScheduledService;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerRunner {
    //every 30 sec - "0/30 * * * * ?"; every day 0:00 - "0 0 0 * * ?"
    private final static String CRON_PATTERN = "0 0 0 * * ?";
    private final static String JOB = "job1";
    private final static String GROUP = "group1";
    private final static String TRIGGER = "trigger1";

    public void startScheduleTask() {
        SchedulerFactory sf = new StdSchedulerFactory();
        try {
            Scheduler sched = sf.getScheduler();

            JobDetail job = JobBuilder.newJob(ScheduledExecutor.class)
                    .withIdentity(JOB, GROUP)
                    .build();



            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(TRIGGER, GROUP)
                    .withSchedule(CronScheduleBuilder.cronSchedule(CRON_PATTERN))
                    .build();

            sched.scheduleJob(job, trigger);
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
