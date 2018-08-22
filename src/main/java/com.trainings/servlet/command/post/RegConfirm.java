package com.trainings.servlet.command.post;

import com.trainings.model.dao.DaoFactory;
import com.trainings.model.dao.UserDao;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class RegConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        UserDao dao = DaoFactory.getInstance().createUserDao();

        String name = req.getParameter("first_name");
        String surname = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password_confirmation = req.getParameter("password_confirmation");

        //TODO check email



        User user = new User.UserBuilder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .role(Role.USER)
                .build();
        dao.create(user);

        System.out.println(user);
        System.out.println(name + surname + email + password + password_confirmation);


        return "redirect:/home";
    }
}
