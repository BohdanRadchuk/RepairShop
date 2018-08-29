package com.trainings.servlet.command.get;

import com.trainings.constant.Url;
import com.trainings.model.entity.Role;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Role role = (Role) req.getSession().getAttribute("role");
        if (role != null) {
            return Url.REDIRECT + role.homePage();
        } else {
            return Url.HOME + Url.JSP;
        }
    }
}
