package com.trainings.servlet.command.get;

import com.trainings.model.entity.Serve;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.impl.ServeServiceImpl;
import com.trainings.servlet.command.post.NoSuchRecordException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class CreateOrder implements com.trainings.servlet.command.ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("createOrder");
        String serveId = req.getParameter("orderId");
        System.out.println("serve id = " + serveId);
        ServeService service = new ServeServiceImpl();

        try {
            Serve ss= service.findById(Integer.valueOf(serveId)).orElseThrow(NoSuchRecordException::new);

        System.out.println("service= " + ss);
        req.setAttribute("service_description", ss);

        } catch (NoSuchRecordException e) {
            e.printStackTrace();

        }
        return "/in/user/neworder.jsp";
    }
}
