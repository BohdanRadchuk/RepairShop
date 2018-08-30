package com.trainings.model.service.impl;

import com.trainings.model.dao.UserDao;
import com.trainings.model.entity.User;
import com.trainings.model.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {


    @Override
    public List<User> findAll() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean userWithEmailExist(String email) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findByEmail(email).isPresent();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = Optional.empty();
        try (UserDao dao = daoFactory.createUserDao()) {
            user = dao.findByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void createNewUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            System.out.println(user);
            dao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
