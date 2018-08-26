package com.trainings.servlet.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Serve;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.impl.ServeServiceImpl;
import com.trainings.servlet.NoSuchRecordException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class CreateOrder implements com.trainings.servlet.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("createOrder");
        String serveId = req.getParameter("serveId");
        System.out.println("serve id = " + serveId);
        ServeService service = new ServeServiceImpl();

        try {
            Serve serve = service.findById(Integer.valueOf(serveId)).orElseThrow(NoSuchRecordException::new);
            System.out.println("service= " + serve);
            req.setAttribute("service_description", serve);
            return Url.USER_NEW_ORDER + Url.JSP;
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
            return Url.REDIRECT + Url.USER_NEW_ORDER;
        }

    }
}
