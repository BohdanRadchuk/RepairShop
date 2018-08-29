package com.trainings.model.service.impl;

import com.trainings.model.dao.CommentDao;
import com.trainings.model.entity.Comment;
import com.trainings.model.entity.Serve;
import com.trainings.model.service.CommentService;

import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    @Override
    public boolean createNewComment(Comment comment) {
        try (CommentDao dao = daoFactory.createCommentDao()) {
            return dao.create(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Serve> findById(int id) {
        return Optional.empty();
    }
}
