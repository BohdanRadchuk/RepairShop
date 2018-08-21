package com.trainings.servlet.filter;

import com.trainings.model.entity.Role;

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


        if (session != null && session.getAttribute("userEmail") != null &&
                session.getAttribute("role") !=null) {

            Role role = (Role)session.getAttribute("role");

            System.err.println("AUTHENTICATION SERVLENT IN WORK Role = " + session.getAttribute("role")
                    + " email = "  + session.getAttribute("userEmail"));
            System.out.println(role.name().toLowerCase() + " ROLe " + req.getRequestURI() + " - REUQEST URI");

            //Role role1 = Role.USER;
            String reqUri = req.getRequestURI();
            System.out.println(role.homePage()  + " - role home page " + reqUri + " -req uri");
            System.out.println(role.homePage().equals(reqUri));

            if (role.homePage().equals(reqUri) || Arrays.asList(role.allowedPages()).contains(reqUri)){
                System.out.println("CONTAIN !!!!!");
                chain.doFilter(req, resp);
            }
            else resp.sendRedirect(role.homePage());


        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
