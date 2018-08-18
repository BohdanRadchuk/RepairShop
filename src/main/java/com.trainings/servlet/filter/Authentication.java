package com.trainings.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        String loginURI = req.getContextPath() + "/login";




        if (session != null && session.getAttribute("user") != null ||
                req.getRequestURI().equals(loginURI)) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }
}
