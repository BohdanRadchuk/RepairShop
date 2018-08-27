package com.trainings.model.service;

import com.trainings.model.entity.Comment;
import com.trainings.model.entity.Serve;

import java.util.Optional;

public interface CommentService extends Service{
    boolean createNewComment (Comment comment);
    Optional<Serve> findById(int id);
}
