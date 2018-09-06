package com.trainings.model.service.ScheduledService;

import com.trainings.constant.LoggerMessage;
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
        log.info(LoggerMessage.SCHEDULE_TASK_TRIGGER);
        try (OrderDao dao = daoFactory.createOrderDao()) {
            LocalDateTime dateArchiveStart = LocalDateTime.now().minusDays(30);
            dao.archiveOldDoneOrders(dateArchiveStart);                                //archive older than 30 days
            log.info(LoggerMessage.SCHEDULE_TASK_COMPLETE);
        } catch (Exception e) {
            e.printStackTrace();

            log.error(e.getMessage() + LoggerMessage.ERR_ORDERS_ARCHIVING);
        }

    }
}
