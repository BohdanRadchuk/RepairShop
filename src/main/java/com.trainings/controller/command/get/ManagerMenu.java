package com.trainings.controller.command.get;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public class ManagerMenu implements ServletCommand {
    private final static String NO_OF_PAGES = "noOfPages";
    private final static String RECORDS_PER_PAGE = "recordsPerPage";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        managerOrdersWithPagination(req);
        return Url.WEBINF + Url.MANAGER_HOME + Url.JSP;
    }


    private void managerOrdersWithPagination(HttpServletRequest req) {
        Integer currentPage = Integer.valueOf(Optional.ofNullable(req.getParameter(GlobalConstants.CURRENT_PAGE))
                .orElse("1"));
        OrderService orderService = new OrderServiceImpl();
        List<ManagerOrderDTO> orders = orderService.findNewOrders(currentPage);
        req.setAttribute(GlobalConstants.ORDERS, orders);

        int rows = orderService.getNumberOfOrderRows();

        int nOfPages = rows / GlobalConstants.MANAGER_ROWS_PER_PAGE;

        if (rows % GlobalConstants.MANAGER_ROWS_PER_PAGE > 0) {
            nOfPages++;
        }
        req.setAttribute(NO_OF_PAGES, nOfPages);
        req.setAttribute(GlobalConstants.CURRENT_PAGE, currentPage);
        req.setAttribute(RECORDS_PER_PAGE, GlobalConstants.MANAGER_ROWS_PER_PAGE);
        req.setAttribute(GlobalConstants.ORDERS, orders);
    }
}
