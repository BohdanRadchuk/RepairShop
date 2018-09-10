package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminEditUser implements com.trainings.controller.command.ServletCommand {
    private UserService us = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        updateUser(req);
        return Url.REDIRECT + Url.ADMIN_USERS_MENU;
    }

    private void updateUser(HttpServletRequest req) {
        int id = Integer.valueOf(req.getParameter(GlobalConstants.ID));
        us.updateUser(new User.UserBuilder()
                .userId(id)
                .name(req.getParameter(GlobalConstants.NAME))
                .surname(req.getParameter(GlobalConstants.SURNAME))
                .email(req.getParameter(GlobalConstants.EMAIL))
                .password(setPassword(req.getParameter(GlobalConstants.PASSWORD), id))
                .role(Role.valueOf(req.getParameter(GlobalConstants.ROLE)))
                .build());
    }

    private String setPassword (String password, int id){
        try {
            return password.equals(us.findById(id).orElseThrow(NoSuchRecordException::new).getPassword())
                    ? password : BCrypt.hashpw(password, BCrypt.gensalt());
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
            return null;
        }
    }
}
