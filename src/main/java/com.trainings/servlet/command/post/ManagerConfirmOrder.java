package com.trainings.servlet.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.util.NoSuchRecordException;
import com.trainings.servlet.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ManagerConfirmOrder implements ServletCommand {
    private static final String PRICE = "price";
    private static final String ORDER_ID = "orderId";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ServletUtil util = new ServletUtil();
        OrderService orderService = new OrderServiceImpl();
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);

            order.setStatus(Status.CONFIRM);
            order.setIdManager(util.getLoggedUserId(req));
            order.setPrice(new BigDecimal(req.getParameter(PRICE)));
            order.setConsiderationDate(LocalDateTime.now());
            orderService.updateOrder(order);
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
        return Url.REDIRECT + Url.MANAGER_HOME;
    }


}
