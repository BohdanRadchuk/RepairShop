package com.trainings.controller.command.get;

import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        return Url.WEBINF + Url.REGISTRATION + Url.JSP;
    }
}
