package com.trainings.controller.command.post;

import com.trainings.constant.Url;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminDeleteUser implements com.trainings.controller.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        UserService us = new UserServiceImpl();
        System.out.println("delete");
        System.out.println(req.getParameter("id_delete"));
        us.deleteUser(Integer.valueOf(req.getParameter("id_delete")));

        return Url.REDIRECT + Url.ADMIN_USERS_MENU;
    }
}
