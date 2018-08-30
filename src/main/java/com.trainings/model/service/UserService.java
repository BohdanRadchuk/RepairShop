package com.trainings.model.service;

import com.trainings.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service {
    List<User> findAll ();

    boolean userWithEmailExist(String email);

    Optional<User> findUserByEmail(String email);

    void createNewUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
