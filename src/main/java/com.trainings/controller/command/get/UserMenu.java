package com.trainings.controller.command.get;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.impl.ServeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserMenu implements ServletCommand {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        getAllServes(req);
        return Url.WEBINF + Url.USER_HOME + Url.JSP;
    }

    private void getAllServes(HttpServletRequest req) {
        ServeService service = new ServeServiceImpl();
        req.setAttribute(GlobalConstants.SERVICES, service.getAllServs());
    }
}
