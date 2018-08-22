package com.trainings.servlet.filter;

import com.trainings.model.entity.Role;
import com.trainings.servlet.command.ServletUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "authentication")
public class Authentication implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/*
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        if(path.contains("add-student")) {//TODO: rewrite add user roles
            if ((teacher = (Teacher) ((HttpServletRequest) servletRequest).getSession().getAttribute("teacher")) != null) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                servletResponse.getWriter().append("AccessDenied");
                return;
            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
*/


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        ServletUtil servletUtil = new ServletUtil();

        Role role = servletUtil.getSessionRole(req);
        String email = servletUtil.getSessionEmail(req);

        System.out.println((session != null) +"- sess "  + (email != null) + " - email " + (role != null) + "-role");

        if (session != null && email != null && role != null) {

            System.err.println("AUTHENTICATION SERVLENT IN WORK Role = " + role
                    + " email = " + email);
//        System.out.println(role.name().toLowerCase() + " ROLe " + req.getRequestURI() + " - REUQEST URI");

            String reqUri = req.getRequestURI();
            if (role.homePage().equals(reqUri) || Arrays.asList(role.allowedPages()).contains(reqUri)) {
                System.out.println("CONTAIN !!!!!");
                chain.doFilter(req, resp);
            } else {
                resp.sendRedirect(role.homePage());
            }
        } else {
            resp.sendRedirect("/login");
        }

    }

    @Override
    public void destroy() {

    }
}
