package com.trainings.model.service;

import com.trainings.model.dao.DaoFactory;

public interface Service {
    DaoFactory daoFactory = DaoFactory.getInstance();

}
