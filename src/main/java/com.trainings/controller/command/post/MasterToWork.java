package com.trainings.controller.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class MasterToWork implements com.trainings.controller.command.ServletCommand {
    private static final String ORDER_ID = "orderId";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ServletUtil util = new ServletUtil();
        OrderService orderService = new OrderServiceImpl();
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);
            order.setStatus(Status.IN_WORK);
            order.setIdMaster(util.getLoggedUserId(req));
            order.setInWorkDate(LocalDateTime.now());
            orderService.updateOrder(order);
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
        return Url.REDIRECT + Url.MASTER_HOME;
    }
}
