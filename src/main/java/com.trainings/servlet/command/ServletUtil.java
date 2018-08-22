package com.trainings.servlet.command;

import com.trainings.model.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;

public class ServletUtil {

    public boolean checkUserLogged(HttpServletRequest req, String email) {
        HttpSession session = req.getSession();

        @SuppressWarnings("unchecked")
        HashMap<String, HttpSession> logged = (HashMap<String, HttpSession>) session.getServletContext()
                .getAttribute("logged_email");
        if (logged.containsKey(email) || getSessionEmail(req) != null) {
            return true;
        } else {
            logged.put(email, session);
            req.getSession().getServletContext().setAttribute("logged_email", logged);
            return false;
        }
    }

    public void setUserEmailAndRole(HttpServletRequest req, Role role, String email) {
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
        /*session.invalidate();*/
        deleteUserFromContext(session, email);

        /*if (email != null) {
            deleteUserFromSession(session);
            deleteUserFromContext(session, email);
        }*/
    }

    private void deleteUserFromSession(HttpSession session) {
        session.setAttribute("userEmail", null);
        session.setAttribute("role", null);
    }

    private void deleteUserFromContext(HttpSession session, String email) {
        HashMap<String, HttpSession> logged = (HashMap<String, HttpSession>) session.getServletContext().
                getAttribute("logged_email");
        if (logged.containsKey(email)) {
            logged.get(email).invalidate();
            logged.remove(email);
            session.getServletContext().setAttribute("logged_email", logged);
            session.getServletContext().getAttribute("logged_email");
        }
    }
}
