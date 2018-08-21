package com.trainings.servlet.command.post;


import com.trainings.model.dao.DaoFactory;
import com.trainings.model.dao.UserDao;
import com.trainings.model.entity.User;
import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.command.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao dao = daoFactory.createUserDao();

        ServletUtil servletUtil = new ServletUtil();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println(req.getSession().getServletContext().getAttribute("logged_email"));

        if (email == null || password == null) {
            return "redirect:/login?err=empty";
        }

        final User user;
        try {
            user = dao.findByEmail(email).orElseThrow(NoSuchUserException::new);
        } catch (NoSuchUserException e) {
            System.out.println("catch find by email in servlet here");
            return "redirect:/login?err=email";
        }

        if (!user.getPassword().equals(password)) {
            return "redirect:/login?err=pass";
        }

        if (!servletUtil.checkUserLogged(req, email)) {
            System.out.println(user.getRole());
            servletUtil.setUserRole(req, user.getRole(), user.getEmail());

            return "redirect:" + user.getRole().homePage();         //successful login

        }else {
            return "redirect:/login?err=logout";
        }

    }
}
