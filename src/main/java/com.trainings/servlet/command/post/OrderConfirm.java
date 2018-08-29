package com.trainings.servlet.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.model.service.impl.ServeServiceImpl;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.servlet.util.NoSuchRecordException;
import com.trainings.servlet.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class OrderConfirm implements com.trainings.servlet.command.ServletCommand {
    private static final String SERVE_ID ="serveId";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        OrderService orderService = new OrderServiceImpl();
        ServletUtil servletUtil = new ServletUtil();
        ServeService serveService = new ServeServiceImpl();
        try {
            orderService.createNewOrder(new Order(servletUtil.getLoggedUserId(req)
                    ,serveService.findById(Integer.valueOf(req.getParameter(SERVE_ID))).
                            orElseThrow(NoSuchRecordException::new).getIdServe()
                    , Status.NEW));

        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }

        return Url.REDIRECT + Url.USER_HOME;
    }
}
