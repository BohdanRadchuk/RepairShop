package com.trainings.servlet.command.post;


import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.servlet.NoSuchRecordException;
import com.trainings.servlet.command.ServletCommand;
import com.trainings.servlet.command.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        UserService service = new UserServiceImpl();
        ServletUtil servletUtil = new ServletUtil();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println(req.getSession().getServletContext().getAttribute("logged_email"));

        if (email == null || password == null) {
            return "redirect:/login?err=empty";
        }


        final User user;
        try {
            user = service.findUserByEmail(email).orElseThrow(NoSuchRecordException::new);
        } catch (NoSuchRecordException e) {
            System.out.println("catch find by email in servlet here");
            return "redirect:/login?err=email";
        }
//        System.out.println( password + " password equal " + user.getPassword() + BCrypt.checkpw(password, user.getPassword()) );
        //if (!BCrypt.checkpw(password, user.getPassword())){
        if (!user.getPassword().equals(password)) {
            return "redirect:/login?err=pass";
        }

        servletUtil.setUserEmailAndRole(req, user.getRole(), user.getEmail());

        String successLoginUrl = "redirect:" + user.getRole().homePage();
        if (servletUtil.checkUserLogged(req, email)) {
            successLoginUrl+="?logged=true";
        }

        return successLoginUrl;         //successful login
        /*}else {
            return "redirect:/login?err=logout";
        }*/

    }
}
