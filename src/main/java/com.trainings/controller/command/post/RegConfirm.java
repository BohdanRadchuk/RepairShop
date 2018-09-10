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
    private UserService userService = new UserServiceImpl();
    private String errorType;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        String name = req.getParameter(GlobalConstants.FIRST_NAME);
        String surname = req.getParameter(GlobalConstants.LAST_NAME);
        String email = req.getParameter(GlobalConstants.EMAIL);
        String password = req.getParameter(GlobalConstants.PASSWORD);
        String passwordConfirmation = req.getParameter(GlobalConstants.PASSWORD_CONFIRM);


        if (checkNameSurnameRegex(name, surname) || checkPasswordConfirmMatch(password, passwordConfirmation)
                || checkEmailAlreadyExist(email)) {
            return Url.REDIRECT + Url.REGISTRATION + errorType;
        } else {
            userService.createNewUser(createNewUserEntity(name, surname, email, password));
            return Url.REDIRECT + Url.HOME + Url.OPERATION_SUCCESS;
        }
    }

    private boolean checkPasswordConfirmMatch(String password, String passwordConfirmation) {
        if (!password.matches(Regex.REG_PASS)) {
            errorType = Url.ERR_PASSWORD_REGEX;
            return true;
        }
        if (!password.equals(passwordConfirmation)) {
            errorType = Url.ERR_PASSWORD;
            return true;
        }
        return false;
    }

    private boolean checkEmailAlreadyExist(String email) {
        if (userService.findUserByEmail(email).isPresent()) {
            errorType = Url.ERR_LOGIN;
            return true;
        } else {
            return false;
        }
    }

    private boolean checkNameSurnameRegex(String name, String surname) {
        if (!(name.matches(Regex.REG_NAME) && surname.matches(Regex.REG_NAME))) {
            errorType = Url.ERR_REGEX;
            return true;
        } else {
            return false;
        }
    }

    private User createNewUserEntity(String name, String surname, String email, String password) {
        return new User.UserBuilder()
                .name(name.trim())
                .surname(surname.trim())
                .email(email.trim())
                .password(BCrypt.hashpw(password, BCrypt.gensalt()))
                .role(Role.USER)
                .build();
    }
}
