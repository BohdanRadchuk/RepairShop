package com.trainings.model.service;

import com.trainings.model.entity.Serve;

import java.util.List;
import java.util.Optional;

public interface ServeService extends Service{
    List<Serve> getAllServs ();
    Optional<Serve> findById (int id);
}
