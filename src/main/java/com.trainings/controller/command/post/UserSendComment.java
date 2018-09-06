package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;
import com.trainings.model.entity.Comment;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;
import com.trainings.model.service.CommentService;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.impl.CommentServiceImpl;
import com.trainings.model.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserSendComment implements com.trainings.controller.command.ServletCommand {
    private OrderService orderService = new OrderServiceImpl();
    private CommentService commentService = new CommentServiceImpl();
    private ServletUtil util = new ServletUtil();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        addCommentIfValid(req, req.getParameter(GlobalConstants.COMMENT));
        return Url.REDIRECT + Url.USERS_ORDERS;
    }

    private void addCommentIfValid(HttpServletRequest req, String commentary) {
        try {
            Order order = orderService.findOrderById(Integer.valueOf(req.getParameter(GlobalConstants.ORDER_ID)))
                    .orElseThrow(NoSuchRecordException::new);
            if (order.getIdUser() == util.getLoggedUserId(req) && !commentary.isEmpty()
                    && order.getStatus().equals(Status.DONE)) {
                commentService.createNewComment(new Comment(order.getIdOrder(), commentary));
            }
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }
    }
}
