package com.trainings;

import com.trainings.servlet.command.*;
import com.trainings.servlet.command.get.Login;
import com.trainings.servlet.command.get.Registration;
import com.trainings.servlet.command.post.LoginConfirm;
import com.trainings.servlet.command.post.RegConfirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bohdan Radchuk
 */
@WebServlet(urlPatterns = {"/home", "/login", "/login_confirm", "/logout", "/registration", "/registration_confirm"})
public class Servlet extends HttpServlet {

    private Map<String, ServletCommand> command = new HashMap<>();

    public void init() {
        command.put("/home", new Home());
        command.put("/registration_confirm", new RegConfirm());
        command.put("/registration", new Registration());
        command.put("/login", new Login());
        command.put("/login_confirm", new LoginConfirm());
        command.put("login/commit", new LoginConfirm());
        command.put("/logout", new Logout());
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleServlet(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleServlet(req, resp);
    }

    private void handleServlet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getRequestURI();
        System.out.println(" path " + path);
        ServletCommand servletCommand = command.getOrDefault(path, (r, q) -> "/index.jsp");
        System.out.println(" servlet command " + servletCommand );
        String page = servletCommand.execute(req, resp);
        if (page.contains("redirect")) {
            resp.sendRedirect(page.replace("redirect:", "/"));
        } else {
            System.out.println("else handleServlet" + page);
            req.getRequestDispatcher("page" + page).forward(req, resp);
        }
    }
}
