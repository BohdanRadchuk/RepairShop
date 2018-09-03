package com.trainings.controller.command.post;


import com.trainings.constant.Url;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserService service = new UserServiceImpl();
        ServletUtil servletUtil = new ServletUtil();

        String email = req.getParameter("email");
        String password = req.getParameter("password");


        if (email == null || password == null) {
            return Url.REDIRECT + Url.LOGIN + "?err=empty";
        }
        final User user;
        try {
            user = service.findUserByEmail(email).orElseThrow(NoSuchRecordException::new);
        } catch (NoSuchRecordException e) {
            return Url.REDIRECT + Url.LOGIN + "?err=email";
        }
        //if (!BCrypt.checkpw(password, user.getPassword())){
        if (!user.getPassword().equals(password)) {
            return Url.REDIRECT + Url.LOGIN + "?err=pass";
        }

        servletUtil.setUserEmailRoleToSession(req, user.getRole(), user.getEmail());
        servletUtil.addToContext(req, email);

        return Url.REDIRECT  +user.getRole().homePage() + Url.JSP;         //successful login

    }
}
