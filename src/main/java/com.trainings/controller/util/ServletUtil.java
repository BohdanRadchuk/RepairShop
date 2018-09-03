package com.trainings.controller.util;

import com.trainings.model.entity.Role;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class ServletUtil {

    public void addToContext(HttpServletRequest req, String email) {
        HttpSession session = req.getSession();
        @SuppressWarnings("unchecked")
        HashMap<String, HttpSession> logged = (HashMap<String, HttpSession>) session.getServletContext()
                .getAttribute("logged_email");
        if (logged.containsKey(email)) {
            deleteUserFromContextAndSession(req);
        }
        logged.put(email, session);
        req.getSession().getServletContext().setAttribute("logged_email", logged);
    }

    public void setUserEmailRoleToSession(HttpServletRequest req, Role role, String email) {
        HttpSession session = req.getSession();

        session.setAttribute("userEmail", email);
        session.setAttribute("role", role);
    }

    public String getSessionEmail(HttpServletRequest req) {
        return (String) req.getSession().getAttribute("userEmail");
    }


    public Role getSessionRole(HttpServletRequest req) {
        return (Role) req.getSession().getAttribute("role");
    }


    public void deleteUserFromContextAndSession(HttpServletRequest req) {

        String email = (String) req.getSession().getAttribute("userEmail");
        HttpSession session = req.getSession();

        @SuppressWarnings("unchecked")
        HashMap<String, HttpSession> logged = (HashMap<String, HttpSession>) session.getServletContext().
                getAttribute("logged_email");
        if (logged.containsKey(email)) {
            try {
                logged.get(email).invalidate();
            } catch (IllegalStateException e) {
                //TODO logadd
            }
            logged.remove(email);
            session.getServletContext().setAttribute("logged_email", logged);
        }
    }

    public int getLoggedUserId(HttpServletRequest req) throws NoSuchRecordException {
        UserService userService = new UserServiceImpl();
        return userService.findUserByEmail(getSessionEmail(req))
                .orElseThrow(NoSuchRecordException::new).getId();
    }

    //TODO regex
    public boolean checkInputSutisfyRegex (String input, String regex){
        return false;
    }

}
