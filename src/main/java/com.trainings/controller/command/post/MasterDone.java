package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class MasterDone implements com.trainings.controller.command.ServletCommand {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        changeOrderStatusDone(req);
        return Url.REDIRECT + Url.MASTER_HOME;
    }

    private void changeOrderStatusDone(HttpServletRequest req) {
        OrderService orderService = new OrderServiceImpl();
        ServletUtil servletUtil = new ServletUtil();
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(GlobalConstants.ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);
            if (order.getStatus().equals(Status.IN_WORK) && servletUtil.getLoggedUserId(req) == order.getIdMaster()) {
                order.setStatus(Status.DONE);
                order.setDoneDate(LocalDateTime.now());
                orderService.updateOrder(order);
            }
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
    }
}
