package com.trainings.controller.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.OrderBuilder;
import com.trainings.model.entity.Status;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.model.service.impl.ServeServiceImpl;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class OrderConfirm implements com.trainings.controller.command.ServletCommand {
    private static final String SERVE_ID ="serveId";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        createNewOrder(req);
        return Url.REDIRECT + Url.USER_HOME;
    }

    private void createNewOrder(HttpServletRequest req) {
        OrderService orderService = new OrderServiceImpl();
        ServletUtil servletUtil = new ServletUtil();
        try {
            orderService.createNewOrder(new OrderBuilder()
                    .setIdUser(servletUtil.getLoggedUserId(req))
                    .setIdServe(Integer.valueOf(req.getParameter(SERVE_ID)))
                    .setStatus(Status.NEW)
                    .createOrder());
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
    }
}
