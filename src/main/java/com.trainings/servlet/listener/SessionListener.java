package com.trainings.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;


public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HashSet<String> logged = (HashSet<String>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute("logged_email");
        String userName = (String) httpSessionEvent.getSession()
                .getAttribute("email");
        logged.remove(userName);
        httpSessionEvent.getSession().setAttribute("logged_email", logged);
    }
}
