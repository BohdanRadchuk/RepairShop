package com.trainings.servlet.command.get;

import com.trainings.constant.Url;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminMenu implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        return Url.ADMIN_HOME + Url.JSP;
    }
}
