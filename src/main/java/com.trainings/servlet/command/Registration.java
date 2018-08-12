package com.trainings.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/registration.jsp";
    }
}
