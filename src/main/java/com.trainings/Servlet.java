package com.trainings;

import com.trainings.servlet.command.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bohdan Radchuk
 */
@WebServlet(urlPatterns = {"/login", "/logout", "/registration", "/registration_confirm"})
public class Servlet extends HttpServlet {

    private Map<String, ServletCommand> command = new HashMap<>();

    public void init() {
        command.put("/registration_confirm", new RegConfirm());
        command.put("/registration", new Registration());
        command.put("/login", new Login());
        command.put("login/commit", new LoginSuccess());
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
        System.out.println(path);
        ServletCommand servletCommand = command.getOrDefault(path, (r, q) -> "/index.jsp");
        System.out.println(servletCommand);
        String page = servletCommand.execute(req, resp);
        if (page.contains("redirect")) {
            resp.sendRedirect(page.replace("redirect:", "/api"));
        } else {
            System.out.println("else handle" + page);
            req.getRequestDispatcher("page" + page).forward(req, resp);
        }
    }
}
