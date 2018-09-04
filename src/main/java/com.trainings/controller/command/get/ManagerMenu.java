package com.trainings.controller.command.get;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.controller.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public class ManagerMenu implements ServletCommand {
    private static final String ORDERS = "orders";


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        pagination(req);
        return Url.WEBINF + Url.MANAGER_HOME + Url.JSP;
    }


    private void pagination(HttpServletRequest req){

        Integer currentPage = Integer.valueOf(Optional.ofNullable(req.getParameter("currentPage"))
                .orElse("1"));

                OrderService orderService = new OrderServiceImpl();


        List<ManagerOrderDTO> orders = orderService.findNewOrders(currentPage);


        req.setAttribute(ORDERS, orders);


        int rows = orderService.getNumberOfOrderRows();
        System.out.println(rows);

        int nOfPages = rows / GlobalConstants.MANAGER_ROWS_PER_PAGE;

        if (rows % GlobalConstants.MANAGER_ROWS_PER_PAGE > 0) {
            nOfPages++;
        }

        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", GlobalConstants.MANAGER_ROWS_PER_PAGE);
        req.setAttribute(ORDERS, orders);
    }
}
