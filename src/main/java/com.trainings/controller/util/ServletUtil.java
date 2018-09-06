package com.trainings.controller.util;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.LoggerMessage;
import com.trainings.model.entity.Role;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class ServletUtil {
    private static Logger logger =  LogManager.getLogger(ServletUtil.class);

    public void addToContext(HttpServletRequest req, String email) {
        HttpSession session = req.getSession();
        @SuppressWarnings("unchecked")
        HashMap<String, HttpSession> logged = (HashMap<String, HttpSession>) session.getServletContext()
                .getAttribute(GlobalConstants.LOGGED_EMAIL);
        if (logged.containsKey(email)) {
            deleteUserFromContextAndSession(req);
        }
        logged.put(email, session);
        req.getSession().getServletContext().setAttribute(GlobalConstants.LOGGED_EMAIL, logged);
    }

    public void setUserEmailRoleToSession(HttpServletRequest req, Role role, String email) {
        HttpSession session = req.getSession();

        session.setAttribute(GlobalConstants.USER_EMAIL, email);
        session.setAttribute(GlobalConstants.ROLE, role);
    }

    public String getSessionEmail(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(GlobalConstants.USER_EMAIL);
    }


    public Role getSessionRole(HttpServletRequest req) {
        return (Role) req.getSession().getAttribute(GlobalConstants.ROLE);
    }


    public void deleteUserFromContextAndSession(HttpServletRequest req) {

        String email = (String) req.getSession().getAttribute(GlobalConstants.USER_EMAIL);
        HttpSession session = req.getSession();

        @SuppressWarnings("unchecked")
        HashMap<String, HttpSession> logged = (HashMap<String, HttpSession>) session.getServletContext()
                .getAttribute(GlobalConstants.LOGGED_EMAIL);
        if (logged.containsKey(email)) {
            try {
                logged.get(email).invalidate();
            } catch (IllegalStateException e) {
                logger.error(e.getMessage() + LoggerMessage.ERR_SESSION_INVALIDATION);
            }
            logged.remove(email);
            session.getServletContext().setAttribute(GlobalConstants.LOGGED_EMAIL, logged);
        }
    }

    public int getLoggedUserId(HttpServletRequest req) throws NoSuchRecordException {
        UserService userService = new UserServiceImpl();
        return userService.findUserByEmail(getSessionEmail(req))
                .orElseThrow(NoSuchRecordException::new).getId();
    }
}
