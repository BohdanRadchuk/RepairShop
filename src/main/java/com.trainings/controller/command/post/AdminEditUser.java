package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminEditUser implements com.trainings.controller.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        updateUser(req);
        return Url.REDIRECT + Url.ADMIN_USERS_MENU;
    }

    private void updateUser(HttpServletRequest req) {
        UserService us = new UserServiceImpl();

        us.updateUser(new User.UserBuilder()
                .userId(Integer.valueOf(req.getParameter(GlobalConstants.ID)))
                .name(req.getParameter(GlobalConstants.NAME))
                .surname(req.getParameter(GlobalConstants.SURNAME))
                .email(req.getParameter(GlobalConstants.EMAIL))
                .password(BCrypt.hashpw(req.getParameter(GlobalConstants.PASSWORD), BCrypt.gensalt()))
                .role(Role.valueOf(req.getParameter(GlobalConstants.ROLE)))
                .build());
    }
}
