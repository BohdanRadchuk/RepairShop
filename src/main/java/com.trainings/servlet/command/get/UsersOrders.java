package com.trainings.servlet.command.get;

import com.trainings.constant.Url;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.servlet.util.NoSuchRecordException;
import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UsersOrders implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("ALL USERS ORDERS");

        OrderService orderService = new OrderServiceImpl();
        UserService userService = new UserServiceImpl();
        ServletUtil servletUtil = new ServletUtil();
        int id  = userService
                .findUserByEmail(servletUtil.getSessionEmail(req)).get().getId();
        System.out.println(id);
        System.out.println(orderService.findAllUsersOrders(id));

        try {
            req.setAttribute("orders", orderService.findAllUsersOrders(userService
                    .findUserByEmail(servletUtil.getSessionEmail(req))
                    .orElseThrow(NoSuchRecordException::new).getId()));


        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }

        return Url.USERS_ORDERS + Url.JSP;
    }
}
