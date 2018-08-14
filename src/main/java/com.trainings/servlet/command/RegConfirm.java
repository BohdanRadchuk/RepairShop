package com.trainings.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("first_name");
        String surname = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password_confirmation = req.getParameter("password_confirmation");
        System.out.println(name + surname + email + password + password_confirmation);

        return "/home.jsp";
    }
}
