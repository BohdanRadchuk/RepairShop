package com.trainings.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author Bohdan Radchuk
 */
//@WebServlet (urlPatterns = {"/login", "/logout"})
public class HouseServlet extends HttpServlet {
    private static final String HOUSE_DEVICES = "HouseDevices";
    private static final String TOTAL_ENERGY = "totalEnergy";
    private static final String HOUSE_JSP = "house.jsp";
    public static final String REDIRECT_URL = "/house";
    private static final String POWER_CHECKBOX_NAME = "switchOption";




    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher(HOUSE_JSP).forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.sendRedirect(REDIRECT_URL);
    }
}
