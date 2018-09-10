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
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ManagerConfirmOrder implements ServletCommand {
    private ServletUtil util = new ServletUtil();
    private OrderService orderService = new OrderServiceImpl();


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        String price = req.getParameter(GlobalConstants.PRICE);


        if (!StringUtils.isNumeric(price)) {                        // Apache Commons Lang here
            return Url.REDIRECT + Url.MANAGER_HOME + Url.ERR_PRICE;
        } else {
            updateOrder(req, price);
        }

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


    private void updateOrder(HttpServletRequest req, String price) {
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(GlobalConstants.ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);
            if (order.getStatus().equals(Status.NEW)) {
                order.setStatus(Status.CONFIRM);
                order.setIdManager(util.getLoggedUserId(req));
                order.setPrice(new BigDecimal(price));
                order.setConsiderationDate(LocalDateTime.now());
                orderService.updateOrder(order);
            }
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
    }
}
