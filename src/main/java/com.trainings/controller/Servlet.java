package com.trainings.controller;

import com.trainings.constant.Url;
import com.trainings.model.service.ScheduledService.SimpleTriggerRunner;
import com.trainings.controller.command.get.Home;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.command.get.*;
import com.trainings.controller.command.post.*;

import javax.servlet.ServletConfig;
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
@WebServlet(urlPatterns = {Url.HOME, Url.LOGIN, Url.LOGIN_CONFIRM, Url.LOGOUT, Url.REGISTRATION,
        Url.REGISTRATION_CONFIRM, Url.USER_HOME, Url.USER_NEW_ORDER, Url.USER_NEW_ORDER_CONFIRM, Url.USERS_ORDERS,
        Url.USER_SEND_COMMENT, Url.MANAGER_HOME, Url.MANAGER_CONFIRM_ORDER, Url.MANAGER_REFUSE_ORDER, Url.MASTER_HOME,
        Url.MASTER_TO_WORK, Url.MASTER_DONE, Url.ADMIN_HOME, Url.ADMIN_USERS_MENU, Url.ADMIN_EDIT_USER,
        Url.ADMIN_DELETE_USER})
public class Servlet extends HttpServlet {

    private static final String EMPTY = "";
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
        command.put("/in/user/user_menu"
                /*Url.USER_HOME*/, new UserMenu());
        command.put(Url.USER_NEW_ORDER, new CreateOrder());
        command.put(Url.USER_NEW_ORDER_CONFIRM, new OrderConfirm());
        command.put(Url.USERS_ORDERS, new UsersOrders());
        command.put(Url.USER_SEND_COMMENT, new UserSendComment());
        command.put(Url.MANAGER_HOME, new ManagerMenu());
        command.put(Url.MANAGER_CONFIRM_ORDER, new ManagerConfirmOrder());
        command.put(Url.MANAGER_REFUSE_ORDER, new ManagerRefuseOrder());
        command.put(Url.MASTER_HOME, new MasterMenu());
        command.put(Url.MASTER_TO_WORK, new MasterToWork());
        command.put(Url.MASTER_DONE, new MasterDone());
        command.put(Url.ADMIN_HOME, new AdminMenu());
        command.put(Url.ADMIN_USERS_MENU, new AdminUsersMenu());
        command.put(Url.ADMIN_EDIT_USER, new AdminEditUser());
        command.put(Url.ADMIN_DELETE_USER, new AdminDeleteUser());

        SimpleTriggerRunner runner = new SimpleTriggerRunner();
        runner.startScheduleTask();
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
                      resp.sendRedirect(page.replace(Url.REDIRECT, EMPTY));
        } else {
            req.getRequestDispatcher(/*Url.PAGE + */page).forward(req, resp);
        }
    }
}
