package com.trainings.servlet.command.get;

import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        return "/registration.jsp";
    }
}
