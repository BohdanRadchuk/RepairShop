package com.trainings.servlet.command.post;

import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.command.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletUtil util = new ServletUtil();
        util.deleteUserFromContextAndSession(req);
        return "/home.jsp";
    }
}
