package com.trainings.servlet.command.post;

import com.trainings.constant.Url;
import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletUtil util = new ServletUtil();
        util.deleteUserFromContextAndSession(req);
        return Url.REDIRECT + Url.HOME;
    }
}
