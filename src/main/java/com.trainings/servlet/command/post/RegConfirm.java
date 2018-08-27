package com.trainings.servlet.command.post;

import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.servlet.command.ServletCommand;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class RegConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        UserService service = new UserServiceImpl();

        String name = req.getParameter("first_name");
        String surname = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password_confirmation = req.getParameter("password_confirmation");

        if (password.equals(password_confirmation) && !service.findUserByEmail(email).isPresent()){
            //BCrypt crypt = new BCrypt();
            String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
            User user = new User.UserBuilder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(pw_hash)
                    .role(Role.USER)
                    .build();

            service.createNewUser(user);

            System.out.println(user);
            System.out.println(name + surname + email + password + password_confirmation);


            return "redirect:/home";
        }else return "/registration";

        //TODO check email and pass confirm make notification about creation

    }
}
