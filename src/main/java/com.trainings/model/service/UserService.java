package com.trainings.model.service;

import com.trainings.model.entity.User;

import java.util.Optional;

public interface UserService extends Service {
    boolean userWithEmailExist(String email);

    Optional<User> findUserByEmail(String email);

    void insertNewUser(User user);
}
