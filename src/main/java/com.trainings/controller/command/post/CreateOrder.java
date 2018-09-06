package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.LoggerMessage;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.util.NoSuchRecordException;
import com.trainings.model.entity.Serve;
import com.trainings.model.service.ServeService;
import com.trainings.model.service.impl.ServeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class CreateOrder implements ServletCommand {
    private static final Logger log = LogManager.getLogger(CreateOrder.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        return getServeToCreateOrder(req);
    }

    private String getServeToCreateOrder(HttpServletRequest req) {
        String serveId = req.getParameter(GlobalConstants.SERVE_ID);
        ServeService service = new ServeServiceImpl();
        try {
            Serve serve = service.findById(Integer.valueOf(serveId)).orElseThrow(NoSuchRecordException::new);
            req.setAttribute(GlobalConstants.SERVICE_DESCRIPTION, serve);
            return Url.WEBINF + Url.USER_NEW_ORDER + Url.JSP;
        } catch (NoSuchRecordException e) {
            e.printStackTrace();
            log.error(e.getMessage() + LoggerMessage.ERR_SERVE_COMMAND_FIND_BY_ID);
            return null;
        }
    }
}
