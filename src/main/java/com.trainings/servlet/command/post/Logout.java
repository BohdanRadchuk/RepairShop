package com.trainings.servlet.command.post;

import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletUtil util = new ServletUtil();
        System.out.println("logout here");
        util.deleteUserFromContextAndSession(req);
        return "redirect:home";
    }
}
