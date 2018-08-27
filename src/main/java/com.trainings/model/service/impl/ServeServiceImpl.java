package com.trainings.model.service.impl;

import com.trainings.model.dao.ServeDao;
import com.trainings.model.entity.Serve;
import com.trainings.model.service.ServeService;

import java.util.List;
import java.util.Optional;

public class ServeServiceImpl implements ServeService {


    @Override
    public List<Serve> getAllServs() {
        try (ServeDao dao = daoFactory.createServeDao()) {
            return dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Serve> findById(int id) {
        Optional<Serve> serve = Optional.empty();
        try (ServeDao dao = daoFactory.createServeDao()) {
            serve = dao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serve;
    }
}