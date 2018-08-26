package com.trainings.servlet.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.entity.User;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.model.service.impl.ServeServiceImpl;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.servlet.NoSuchRecordException;
import com.trainings.servlet.command.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class OrderConfirm implements com.trainings.servlet.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("ORDER CONFIRM");

        OrderService orderService = new OrderServiceImpl();
        UserService userService = new UserServiceImpl();
        ServletUtil servletUtil = new ServletUtil();
        ServeService serveService = new ServeServiceImpl();


        try {
            System.out.println(req.getParameter("serveId"));
            // is it ok ?
            orderService.createNewOrder(new Order(userService
                    .findUserByEmail(servletUtil.getSessionEmail(req)).orElseThrow(NoSuchRecordException::new).getId()
                    ,serveService.findById(Integer.valueOf(req.getParameter("serveId"))).
                            orElseThrow(NoSuchRecordException::new).getIdServe()
                    , Status.NEW));
            ;
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }

        return Url.REDIRECT + Url.USER_HOME;
    }
}
