package com.trainings.model.service.impl;

import com.trainings.constant.LoggerMessage;
import com.trainings.model.dao.CommentDao;
import com.trainings.model.entity.Comment;
import com.trainings.model.service.CommentService;

public class CommentServiceImpl implements CommentService {
    @Override
    public boolean createNewComment(Comment comment) {
        try (CommentDao dao = daoFactory.createCommentDao()) {
            return dao.create(comment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage() + LoggerMessage.ERR_COMMENT_SERVICE_CREATE_COMMENT);
            return false;
        }
    }

}
