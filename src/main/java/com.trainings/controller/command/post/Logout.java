package com.trainings.controller.command.post;

import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.ServletUtil;

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
