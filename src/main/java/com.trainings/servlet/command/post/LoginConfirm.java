package com.trainings.servlet.command.post;


import com.trainings.model.dao.DaoFactory;
import com.trainings.model.dao.UserDao;
import com.trainings.model.entity.User;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao dao = daoFactory.createUserDao();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email != null && password != null) {

            User userf;
            try {
                userf = dao.findByEmail(email).orElseThrow(NoSuchUserException::new);
            } catch (NoSuchUserException e) {
                System.out.println("catch find by email in servlet here");
                req.setAttribute("error", "No such email registered");
                return "redirect:login?err=email";
            }

            if (userf.getPassword().equals(password)) {
                System.out.println(userf.getRole());
                return "redirect:" + userf.getRole().homePage();
            } else {
                req.setAttribute("error", "wrong password");
                return "redirect:login?err=pass";
            }
        } else return "redirect:login?err=empty";

    }
}
