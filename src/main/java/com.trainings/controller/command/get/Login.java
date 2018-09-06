package com.trainings.controller.command.get;

import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        checkClearSession(req);
        return Url.WEBINF + Url.LOGIN + Url.JSP;
    }

    private void checkClearSession(HttpServletRequest req) {
        ServletUtil servletUtil = new ServletUtil();
        if (servletUtil.getSessionEmail(req) != null) {
            servletUtil.deleteUserFromContextAndSession(req);
        }
    }
}
