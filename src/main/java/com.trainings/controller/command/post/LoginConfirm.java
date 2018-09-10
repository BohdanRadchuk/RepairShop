package com.trainings.controller.command.post;


import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.controller.util.ServletUtil;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginConfirm implements ServletCommand {
    private UserService service = new UserServiceImpl();
    private ServletUtil servletUtil = new ServletUtil();


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        String email = req.getParameter(GlobalConstants.EMAIL);
        String password = req.getParameter(GlobalConstants.PASSWORD);


        if (email == null || password == null) {
            return Url.REDIRECT + Url.LOGIN + Url.ERR_EMPTY;
        }

        final User user;
        try {
            user = service.findUserByEmail(email).orElseThrow(NoSuchRecordException::new);
        } catch (NoSuchRecordException e) {
            return Url.REDIRECT + Url.LOGIN + Url.ERR_EMAIL;
        }
        if (!BCrypt.checkpw(password, user.getPassword())){
            return Url.REDIRECT + Url.LOGIN + Url.ERR_PASSWORD;
        }

        servletUtil.setUserEmailRoleToSession(req, user.getRole(), user.getEmail());
        servletUtil.addToContext(req, email);

        return Url.REDIRECT + user.getRole().homePage() + Url.JSP;         //successful login

    }
}
