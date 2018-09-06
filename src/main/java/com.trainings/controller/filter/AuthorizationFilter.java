package com.trainings.controller.filter;

import com.trainings.constant.Url;
import com.trainings.controller.util.ServletUtil;
import com.trainings.model.entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "authentication")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        ServletUtil servletUtil = new ServletUtil();

        Role role = servletUtil.getSessionRole(req);
        String email = servletUtil.getSessionEmail(req);

        String reqUri = req.getRequestURI();

        if (session != null && email != null && role != null) {
            if (role.homePage().equals(reqUri) || Arrays.asList(role.allowedPages()).contains(reqUri)) {
                chain.doFilter(req, resp);
            } else {
                resp.sendRedirect(role.homePage());
            }
        } else {
            resp.sendRedirect(Url.LOGIN);
        }
    }

    @Override
    public void destroy() {
    }
}
