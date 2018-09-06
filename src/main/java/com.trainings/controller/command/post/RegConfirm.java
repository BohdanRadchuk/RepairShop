package com.trainings.controller.command.post;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.Regex;
import com.trainings.constant.Url;
import com.trainings.controller.command.ServletCommand;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;
import com.trainings.model.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class RegConfirm implements ServletCommand {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        UserService service = new UserServiceImpl();
        String name = req.getParameter(GlobalConstants.FIRST_NAME);
        String surname = req.getParameter(GlobalConstants.LAST_NAME);
        String email = req.getParameter(GlobalConstants.EMAIL);
        String password = req.getParameter(GlobalConstants.PASSWORD);
        String password_confirmation = req.getParameter(GlobalConstants.PASSWORD_CONFIRM);

        if (!checkRegex(name, surname, password)){
            return Url.REDIRECT + Url.REGISTRATION + Url.ERR_REGEX;
        }

        if (service.findUserByEmail(email).isPresent()) {
            return Url.REDIRECT + Url.REGISTRATION + Url.ERR_LOGIN;
        }
        if (!password.equals(password_confirmation)) {
            return Url.REDIRECT + Url.REGISTRATION + Url.ERR_PASSWORD;
        } else {
            createNewUser(service, name, surname, email, password);
            return Url.REDIRECT + Url.HOME;
        }
    }

    private boolean checkRegex(String name, String surname, String password) {
        return name.matches(Regex.REG_NAME) && surname.matches(Regex.REG_NAME) && password.matches(Regex.REG_PASS);
    }

    private void createNewUser(UserService service, String name, String surname, String email, String password) {
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User.UserBuilder()
                .name(name.trim())
                .surname(surname.trim())
                .email(email.trim())
                .password(pw_hash)
                .role(Role.USER)
                .build();
        service.createNewUser(user);
    }
}
