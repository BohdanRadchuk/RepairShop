package com.trainings.controller.command.get;

import com.trainings.constant.Url;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.controller.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class ManagerMenu implements ServletCommand {
    private static final String ORDERS = "orders";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        OrderService orderService = new OrderServiceImpl();
        req.setAttribute(ORDERS, orderService.findNewOrders());
        return Url.WEBINF + Url.MANAGER_HOME + Url.JSP;
    }
}
