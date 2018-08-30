package com.trainings.model.dao;

import com.trainings.model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User, Integer> {
    Optional<User> findByEmail (String email);
}
