package com.trainings.model.service.impl;

import com.trainings.model.dao.UserDao;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    UserDao dao = daoFactory.createUserDao();

    @Override
    public boolean userWithEmailExist(String email) {
        return dao.findByEmail(email).isPresent();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {

        return dao.findByEmail(email);
    }

    @Override
    public void insertNewUser(User user) {
        System.out.println(user.getPassword() + " Hashed password ");
        dao.create(user);
    }
}
