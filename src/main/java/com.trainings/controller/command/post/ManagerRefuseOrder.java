package com.trainings.controller.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class ManagerRefuseOrder implements ServletCommand{
    private static final String REASON = "reason";
    private static final String ORDER_ID = "orderId";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ServletUtil util = new ServletUtil();
        OrderService orderService = new OrderServiceImpl();
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);
            order.setStatus(Status.REFUSE);
            order.setIdManager(util.getLoggedUserId(req));
            order.setRefuseReason(req.getParameter(REASON));
            order.setConsiderationDate(LocalDateTime.now());
            orderService.updateOrder(order);
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
        return Url.REDIRECT + Url.MANAGER_HOME;
    }
}
