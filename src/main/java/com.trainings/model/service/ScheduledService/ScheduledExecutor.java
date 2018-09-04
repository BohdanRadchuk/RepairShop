package com.trainings.model.service.ScheduledService;

import com.trainings.model.dao.OrderDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

import static com.trainings.model.service.Service.daoFactory;

public class ScheduledExecutor implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("task triggered ");
        try (OrderDao dao = daoFactory.createOrderDao()) {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(30);
            dao.archiveOldDoneOrders(localDateTime);                                //archive older than 30 days
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
