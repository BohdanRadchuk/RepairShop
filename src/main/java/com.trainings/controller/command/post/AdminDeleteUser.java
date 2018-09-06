package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminDeleteUser implements com.trainings.controller.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        deleteUser(req);
        return Url.REDIRECT + Url.ADMIN_USERS_MENU;
    }

    private void deleteUser(HttpServletRequest req) {
        UserService us = new UserServiceImpl();
        us.deleteUser(Integer.valueOf(req.getParameter(GlobalConstants.ID_DELETE)));
    }
}
