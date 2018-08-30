package com.trainings.servlet.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminEditUser implements com.trainings.servlet.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        UserService us = new UserServiceImpl();
        System.out.println("update");
        User asd = new User.UserBuilder()
                .userId(Integer.valueOf(req.getParameter("id")))
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(Role.valueOf(req.getParameter("role")))
                .build();
        System.out.println(asd);

        us.updateUser(asd);

        return Url.REDIRECT + Url.ADMIN_USERS_MENU;
    }
}
