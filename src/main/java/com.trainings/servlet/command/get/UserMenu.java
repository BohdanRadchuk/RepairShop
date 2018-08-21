package com.trainings.servlet.command.get;

import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserMenu implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("USER MENU HERE");
        return "in/user/user.jsp";

    }
}
