package com.trainings.controller.command.post;

import com.trainings.constant.Url;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import com.trainings.controller.command.ServletCommand;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class RegConfirm implements ServletCommand {
    private final static String FIRST_NAME = "first_name";
    private final static String LAST_NAME = "last_name";
    private final static String EMAIL = "email";
    private final static String PASSWORD = "password";
    private final static String PASSWORD_CONFIRM = "password_confirmation";
    private final static String ERR_LOGIN = "?err=login";
    private final static String ERR_PASSWORD = "?err=pass";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        UserService service = new UserServiceImpl();

        String name = req.getParameter(FIRST_NAME);
        String surname = req.getParameter(LAST_NAME);
        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        String password_confirmation = req.getParameter(PASSWORD_CONFIRM);

        if(service.findUserByEmail(email).isPresent()){

            return Url.REDIRECT + Url.REGISTRATION + ERR_LOGIN;
        }

        if (password.equals(password_confirmation)) {
            String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
            User user = new User.UserBuilder()
                    .name(name.trim())
                    .surname(surname.trim())
                    .email(email.trim())
                    .password(pw_hash)
                    .role(Role.USER)
                    .build();
            service.createNewUser(user);
            return Url.REDIRECT + Url.HOME;
        } else return Url.REDIRECT + Url.REGISTRATION + ERR_PASSWORD;
    }
}
