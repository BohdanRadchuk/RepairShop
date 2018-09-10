package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;

public class ManagerRefuseOrder implements ServletCommand {
    private OrderService orderService = new OrderServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        refuseOrder(req);
        return Url.REDIRECT + Url.MANAGER_HOME + GlobalConstants.CURRENT_PAGE_PARAM + getCurrentOrderPaginationPage(req);
    }

    private Integer getCurrentOrderPaginationPage(HttpServletRequest req) {
        Integer page = Integer.valueOf(Optional.ofNullable(req.getParameter(GlobalConstants.CURRENT_PAGE))
                .orElse("1"));
        if (!orderService.checkHasMoreRecordsOnPage() && page > 1) {
            page--;
        }
        return page;
    }

    private void refuseOrder(HttpServletRequest req) {
        ServletUtil util = new ServletUtil();

        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(GlobalConstants.ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);
            if (order.getStatus().equals(Status.NEW)) {
                order.setStatus(Status.REFUSE);
                order.setIdManager(util.getLoggedUserId(req));
                order.setRefuseReason(req.getParameter(GlobalConstants.REASON));
                order.setConsiderationDate(LocalDateTime.now());
                orderService.updateOrder(order);
            }
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
    }
}
