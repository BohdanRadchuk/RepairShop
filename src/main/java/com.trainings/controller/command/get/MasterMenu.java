package com.trainings.controller.command.get;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class MasterMenu implements ServletCommand {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        getAcceptedAndMastersInWorkOrders(req);
        return Url.WEBINF + Url.MASTER_HOME + Url.JSP;
    }

    private void getAcceptedAndMastersInWorkOrders(HttpServletRequest req) {
        OrderService orderService = new OrderServiceImpl();
        ServletUtil servletUtil = new ServletUtil();
        try {
            req.setAttribute(GlobalConstants.ORDERS, orderService.findConfirmOrders(servletUtil.getLoggedUserId(req)));
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
    }
}
