package com.trainings.servlet.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Comment;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.User;
import com.trainings.model.service.CommentService;
import com.trainings.model.service.OrderService;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.CommentServiceImpl;
import com.trainings.model.service.impl.OrderServiceImpl;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.servlet.util.NoSuchRecordException;
import com.trainings.servlet.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserSendComment implements com.trainings.servlet.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        OrderService orderService = new OrderServiceImpl();
        UserService userService = new UserServiceImpl();
        CommentService commentService = new CommentServiceImpl();
        ServletUtil util = new ServletUtil();

        String commentary =  req.getParameter("comment");

        Order order;

        try {
            order = orderService.findOrderById(Integer.valueOf(req.getParameter("orderId")))
                    .orElseThrow(NoSuchRecordException::new);
            if (order.getIdUser() == util.getLoggedUserId(req) && !commentary.isEmpty()){
                commentService.createNewComment(new Comment(order.getIdOrder(), commentary));
            }
            else {
                return  Url.USERS_ORDERS + Url.JSP;
            }

        } catch (NoSuchRecordException e) {
            e.printStackTrace();
        }


        return Url.REDIRECT + Url.USER_HOME;
    }
}
