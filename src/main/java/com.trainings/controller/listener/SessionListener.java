package com.trainings.controller.listener;

import com.trainings.constant.GlobalConstants;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;


public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        @SuppressWarnings("unchecked")
        Map<String, HttpSession> logged = (HashMap<String, HttpSession>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute(GlobalConstants.LOGGED_EMAIL);
        String userName = (String) httpSessionEvent.getSession()
                .getAttribute(GlobalConstants.EMAIL);
        logged.remove(userName);
        httpSessionEvent.getSession().setAttribute(GlobalConstants.LOGGED_EMAIL, logged);
    }
}
