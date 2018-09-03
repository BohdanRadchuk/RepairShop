package com.trainings.controller.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Serve;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.impl.ServeServiceImpl;
import com.trainings.controller.util.NoSuchRecordException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class CreateOrder implements com.trainings.controller.command.ServletCommand {
    private static final String SERVICE_DESCRIPTION = "service_description";
    private static final String SERVICE_ID = "serveId";
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        String serveId = req.getParameter(SERVICE_ID);
        ServeService service = new ServeServiceImpl();
        try {
            Serve serve = service.findById(Integer.valueOf(serveId)).orElseThrow(NoSuchRecordException::new);
            req.setAttribute(SERVICE_DESCRIPTION, serve);
            return Url.WEBINF + Url.USER_NEW_ORDER + Url.JSP;
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
            return Url.REDIRECT + Url.USER_NEW_ORDER;
        }
    }
}
