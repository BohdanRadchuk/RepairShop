package com.trainings.servlet.command;

import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class ServletUtil {

    public boolean checkUserLogged(HttpServletRequest req, String email) {
        @SuppressWarnings("unchecked")
        HashSet<String> logged = (HashSet<String>) req.getSession().getServletContext().getAttribute("logged_email");
        if (logged.contains(email) || req.getSession().getAttribute("userEmail") != null) {
            return true;
        } else {
            logged.add(email);
            req.getSession().getServletContext().setAttribute("logged_email", logged);
            return false;
        }
    }

    public void setUserRole(HttpServletRequest req, Role role, String email) {
        HttpSession session = req.getSession();

        session.setAttribute("userEmail", email);
        session.setAttribute("role", role);
    }


    public void deleteUserFromContextAndSession(HttpServletRequest req) {

        String email = (String) req.getSession().getAttribute("userEmail");
        HttpSession session = req.getSession();

        if (email != null) {
            deleteUserFromSession(session);
            deleteUserFromContext(session, email);
        }
    }

    private void deleteUserFromSession(HttpSession session) {
        session.setAttribute("userEmail", null);
        session.setAttribute("role", null);
    }

    private void deleteUserFromContext(HttpSession session, String email) {
        HashSet<String> logged = (HashSet<String>) session.getServletContext().getAttribute("logged_email");
        if (logged.contains(email)) {
            logged.remove(email);
            session.getServletContext().setAttribute("logged_email", logged);
        }
    }
}
