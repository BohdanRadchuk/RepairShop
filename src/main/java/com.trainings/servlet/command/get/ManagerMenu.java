package com.trainings.servlet.command.get;

import com.trainings.constant.Url;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class ManagerMenu implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        OrderService orderService = new OrderServiceImpl();



        req.setAttribute("orders", orderService.findNewOrders());




        return Url.MANAGER_HOME + Url.JSP;
    }
}
