package com.trainings.model.service;

import com.trainings.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service {
    Logger logger = LogManager.getLogger(UserService.class);

    List<User> findAll();

    boolean userWithEmailExist(String email);

    Optional<User> findById (int id);

    Optional<User> findUserByEmail(String email);

    void createNewUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
