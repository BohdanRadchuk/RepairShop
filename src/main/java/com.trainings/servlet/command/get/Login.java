package com.trainings.servlet.command.get;

import com.trainings.constant.Url;
import com.trainings.servlet.Servlet;
import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletUtil servletUtil = new ServletUtil();
        if (servletUtil.getSessionEmail(req)!=null){
            servletUtil.deleteUserFromContextAndSession(req);
        }
        return Url.LOGIN + Url.JSP;
    }
}
