package com.trainings.model.service;

import com.trainings.model.entity.Serve;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public interface ServeService extends Service {
    Logger logger = LogManager.getLogger(ServeService.class);

    List<Serve> getAllServs();

    Optional<Serve> findById(int id);
}
