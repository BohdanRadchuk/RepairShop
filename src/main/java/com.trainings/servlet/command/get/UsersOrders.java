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
    private static final String ORDERS = "orders";
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        OrderService orderService = new OrderServiceImpl();
        ServletUtil servletUtil = new ServletUtil();
        try {
            req.setAttribute(ORDERS, orderService.findAllUsersOrders(servletUtil.getLoggedUserId(req)));
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
        return Url.USERS_ORDERS + Url.JSP;
    }
}
