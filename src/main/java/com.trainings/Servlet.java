package com.trainings;

import com.trainings.constant.Url;
import com.trainings.servlet.command.*;
import com.trainings.servlet.command.get.Login;
import com.trainings.servlet.command.get.Registration;
import com.trainings.servlet.command.get.UserMenu;
import com.trainings.servlet.command.post.LoginConfirm;
import com.trainings.servlet.command.post.Logout;
import com.trainings.servlet.command.post.RegConfirm;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Bohdan Radchuk
 */
@WebServlet(urlPatterns = {Url.HOME, Url.LOGIN, Url.LOGIN_CONFIRM, Url.LOGOUT, Url.REGISTRATION,
        Url.REGISTRATION_CONFIRM, Url.USER_HOME})
public class Servlet extends HttpServlet {

    private Map<String, ServletCommand> command = new HashMap<>();

    public void init(ServletConfig config) {
        config.getServletContext()
                .setAttribute("logged_email", new HashMap<String, HttpSession>());


        command.put(Url.HOME, new Home());
        command.put(Url.REGISTRATION_CONFIRM, new RegConfirm());
        command.put(Url.REGISTRATION, new Registration());
        command.put(Url.LOGIN, new Login());
        command.put(Url.LOGIN_CONFIRM, new LoginConfirm());
        command.put(Url.LOGOUT, new Logout());
        command.put(Url.USER_HOME, new UserMenu());
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleServlet(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleServlet(req, resp);
    }

    private void handleServlet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getRequestURI();
        ServletCommand servletCommand = command.getOrDefault(path, (r, q) -> Url.HOME);
        String page = servletCommand.execute(req, resp);
        if (page.contains(Url.REDIRECT)) {
            System.out.println("redirect here to " + path);
            resp.sendRedirect(page.replace(Url.REDIRECT, ""));
        } else {
            System.out.println("else handleServlet forward /page" + page);
            req.getRequestDispatcher(Url.PAGE + page).forward(req, resp);
        }
    }
}
