package com.trainings.model.service;

import com.trainings.model.entity.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface CommentService extends Service {
    Logger logger = LogManager.getLogger(CommentService.class);

    boolean createNewComment(Comment comment);
}
