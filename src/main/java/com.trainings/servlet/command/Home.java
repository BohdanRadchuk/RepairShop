package com.trainings.servlet.command;

import com.trainings.model.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("home here");
        Role role = (Role) req.getSession().getAttribute("role");
        if (role != null) {
            return "redirect:" + role.homePage();
        } else {
            return "/home.jsp";
        }
    }
}
