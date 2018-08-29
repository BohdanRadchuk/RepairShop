package com.trainings.servlet.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;


public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        @SuppressWarnings("unchecked")
        HashMap<String, HttpSession> logged = (HashMap<String, HttpSession>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute("logged_email");
        String userName = (String) httpSessionEvent.getSession()
                .getAttribute("email");
        logged.remove(userName);
        httpSessionEvent.getSession().setAttribute("logged_email", logged);
    }
}
