package com.trainings.controller.command.get;

import com.trainings.constant.Url;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminUsersMenu implements com.trainings.controller.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        UserService service = new UserServiceImpl();
        req.setAttribute("users", service.findAll());

        return Url.WEBINF + Url.ADMIN_USERS_MENU + Url.JSP;
    }
}
