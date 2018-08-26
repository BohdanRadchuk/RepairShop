package com.trainings.model.service.impl;

import com.trainings.model.dao.ServeDao;
import com.trainings.model.entity.Serve;
import com.trainings.model.service.ServeService;

import java.util.List;
import java.util.Optional;

public class ServeServiceImpl implements ServeService {
    ServeDao dao = daoFactory.createServeDao();

    @Override
    public List<Serve> getAllServs() {
        return  dao.findAll();
    }

    @Override
    public Optional<Serve> findById(int id) {
        return dao.findById(id);
    }
}
