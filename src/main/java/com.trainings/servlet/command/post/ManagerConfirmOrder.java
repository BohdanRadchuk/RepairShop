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
import java.time.LocalDateTime;

public class ManagerConfirmOrder implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ServletUtil util = new ServletUtil();
        UserService userService = new UserServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter("orderId")))
                    .orElseThrow(NoSuchRecordException::new);


            order.setStatus(Status.CONFIRM);
            order.setIdManager(userService.findUserByEmail(util.getSessionEmail(req))
                    .orElseThrow(NoSuchRecordException::new).getId());
            order.setConsiderationDate(LocalDateTime.now());

            orderService.updateOrder(order);
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
        return Url.REDIRECT + Url.MANAGER_HOME;
    }
}
