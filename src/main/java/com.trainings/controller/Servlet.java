package com.trainings.controller;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.controller.command.get.*;
import com.trainings.controller.command.post.*;
import com.trainings.model.service.ScheduledService.SimpleTriggerRunner;

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
 * Realization of command pattern to make
 * all requests being handled by one servlet
 *
 * @author Bohdan Radchuk
 * @see javax.servlet.http.HttpServlet;
 */
@WebServlet(urlPatterns = {Url.HOME, Url.LOGIN, Url.LOGIN_CONFIRM, Url.LOGOUT, Url.REGISTRATION,
        Url.REGISTRATION_CONFIRM, Url.USER_HOME, Url.USER_NEW_ORDER, Url.USER_NEW_ORDER_CONFIRM, Url.USERS_ORDERS,
        Url.USER_SEND_COMMENT, Url.MANAGER_HOME, Url.MANAGER_CONFIRM_ORDER, Url.MANAGER_REFUSE_ORDER, Url.MASTER_HOME,
        Url.MASTER_TO_WORK, Url.MASTER_DONE, Url.ADMIN_HOME, Url.ADMIN_USERS_MENU, Url.ADMIN_EDIT_USER,
        Url.ADMIN_DELETE_USER})
public class Servlet extends HttpServlet {

    private static final String EMPTY = "";
    private Map<String, ServletCommand> command = new HashMap<>();


    /**
     * method runs after first servlet launch
     *
     * @param config A servlet configuration object used by a servlet container
     *               to pass information to a servlet during initialization.
     */
    public void init(ServletConfig config) {

        config.getServletContext()
                .setAttribute(GlobalConstants.LOGGED_EMAIL, new HashMap<String, HttpSession>());

        command.put(Url.HOME, new Home());
        command.put(Url.REGISTRATION_CONFIRM, new RegConfirm());
        command.put(Url.REGISTRATION, new Registration());
        command.put(Url.LOGIN, new Login());
        command.put(Url.LOGIN_CONFIRM, new LoginConfirm());
        command.put(Url.LOGOUT, new Logout());
        command.put(Url.USER_HOME, new UserMenu());
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


    /**
     * Called by the server (via the <code>service</code> method) to
     * allow a servlet to handle a GET request.
     *
     * @param req  object that contains the request the client has made
     *             of the servlet
     * @param resp object that contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleServlet(req, resp);
    }


    /**
     * Called by the server (via the <code>service</code> method) to
     * allow a servlet to handle a POST request.
     *
     * @param req  object that contains the request the client has made
     *             of the servlet
     * @param resp object that contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleServlet(req, resp);
    }


    /**Launch command that would handle request
     * if command contains "redirect" at beginning makes redirect to url.
     *
     *@param req  object that contains the request the client has made
     *             of the servlet
     * @param resp object that contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     */
    private void handleServlet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getRequestURI();
        ServletCommand servletCommand = command.getOrDefault(path, (r, q) -> Url.HOME);
        String page = servletCommand.execute(req, resp);
        if (page.contains(Url.REDIRECT)) {
            resp.sendRedirect(page.replace(Url.REDIRECT, EMPTY));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }
}
