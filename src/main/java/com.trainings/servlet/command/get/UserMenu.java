package com.trainings.servlet.command.get;

import com.trainings.constant.Url;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.impl.ServeServiceImpl;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserMenu implements ServletCommand {
    private static final String SERVICES = "services";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        ServeService service = new ServeServiceImpl();
        req.setAttribute(SERVICES, service.getAllServs());
        return Url.USER_HOME + Url.JSP;

    }
}
