package com.trainings.servlet.command.post;


import com.trainings.model.dao.ConnectionPoolHolder;
import com.trainings.model.dao.DaoFactory;
import com.trainings.model.dao.UserDao;
import com.trainings.model.dao.impl.JDBCDaoFactory;
import com.trainings.model.dao.impl.JDBCUserDao;
import com.trainings.model.entity.User;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class LoginConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao dao = daoFactory.createUserDao();


        Optional<User> user = dao.findById(1);
        System.out.println(user + " user in servlet");


        String email = req.getParameter("email");
        String password = req.getParameter("password");



        if (email!=null && password!=null){

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
            }else {
                req.setAttribute("error", "wrong password");
                return "redirect:login?err=pass";
            }
        }else return "redirect:login?err=empty";

    }
}
