package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
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

public class ManagerRefuseOrder implements ServletCommand {


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        refuseOrder(req);
        return Url.REDIRECT + Url.MANAGER_HOME;
    }

    private void refuseOrder(HttpServletRequest req) {
        ServletUtil util = new ServletUtil();
        OrderService orderService = new OrderServiceImpl();
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(GlobalConstants.ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);
            order.setStatus(Status.REFUSE);
            order.setIdManager(util.getLoggedUserId(req));
            order.setRefuseReason(req.getParameter(GlobalConstants.REASON));
            order.setConsiderationDate(LocalDateTime.now());
            orderService.updateOrder(order);
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
    }
}
