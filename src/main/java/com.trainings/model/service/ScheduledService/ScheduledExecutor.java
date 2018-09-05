package com.trainings.model.service.ScheduledService;

import com.trainings.model.dao.OrderDao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

import static com.trainings.model.service.Service.daoFactory;

public class ScheduledExecutor implements Job {
    private static final Logger log = LogManager.getLogger(ScheduledExecutor.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Schedule task triggered");
        try (OrderDao dao = daoFactory.createOrderDao()) {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(30);
            dao.archiveOldDoneOrders(localDateTime);                                //archive older than 30 days
            log.info("Schedule task successfully complete");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage() + "Cant complete orders archiving");
        }

    }
}
