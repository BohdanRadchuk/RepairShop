package com.trainings.model.service.impl;

import com.trainings.constant.LoggerMessage;
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
            logger.error(e.getMessage() + LoggerMessage.ERR_USER_SERVICE_FIND_ALL);
            return null;
        }
    }

    @Override
    public boolean userWithEmailExist(String email) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findByEmail(email).isPresent();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage() + LoggerMessage.ERR_USER_SERVICE_USER_EMAIL_EXIST);
            return false;
        }


    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> user = Optional.empty();
        try (UserDao dao = daoFactory.createUserDao()) {
            user = dao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage() + LoggerMessage.ERR_USER_SERVICE_USER_FIND_EMAIL);
        }
        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = Optional.empty();
        try (UserDao dao = daoFactory.createUserDao()) {
            user = dao.findByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage() + LoggerMessage.ERR_USER_SERVICE_USER_FIND_EMAIL);
        }
        return user;
    }

    @Override
    public void createNewUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.create(user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage() + LoggerMessage.ERR_USER_SERVICE_CREATE_USER);
        }
    }

    @Override
    public void updateUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage() + LoggerMessage.ERR_USER_SERVICE_UPDATE_USER);
        }
    }

    @Override
    public void deleteUser(int id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage() + LoggerMessage.ERR_USER_SERVICE_DELETE_USER);
        }
    }
}
