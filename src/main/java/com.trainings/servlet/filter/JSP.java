package com.trainings.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "jsp")
public class JSP implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println("filter .jsp in work!");
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.sendRedirect("/home");
    }

    @Override
    public void destroy() {

    }
}
