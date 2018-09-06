package com.trainings.controller.command.get;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.model.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Role role = (Role) req.getSession().getAttribute(GlobalConstants.ROLE);
        if (role != null) {
            return Url.REDIRECT + role.homePage();
        } else {
            return Url.PAGE + Url.HOME + Url.JSP;
        }
    }
}
