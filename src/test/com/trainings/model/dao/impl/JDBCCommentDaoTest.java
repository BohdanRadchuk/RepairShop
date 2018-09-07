package com.trainings.model.dao.impl;

import com.trainings.model.dao.CommentDao;
import com.trainings.model.dao.factory.DaoFactory;
import com.trainings.model.entity.Comment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCCommentDaoTest {

    private CommentDao commentDao;
    private Comment testComment;

    @Before
    public void setUp() throws Exception {
        commentDao = DaoFactory.getInstance().createCommentDao();
        testComment = new Comment(25,"test comment");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        commentDao.create(testComment);

        List<Comment> comments = commentDao.findAll();
        Assert.assertEquals(comments.get(comments.size() - 1), testComment);
    }

    @Test
    public void findById() {
        commentDao.create(testComment);
        Assert.assertEquals(commentDao.findById(-1), null);

        List<Comment> comments = commentDao.findAll();
        Assert.assertEquals(comments.get(comments.size() - 1), testComment);

        int id = comments.get(comments.size() - 1).getIdOrder();
        Assert.assertEquals(testComment, commentDao.findById(id));
    }

    @Test
    public void findAll() {
        int sizeAllTable = commentDao.findAll().size();
        commentDao.create(testComment);

        Assert.assertEquals(commentDao.findAll().size(), sizeAllTable + 1);
    }

   /* @Test
    public void update() {
        testComment.setIdOrder(-1);

        commentDao.create(testComment);

        testComment.setCommentary("updated test comment");
        commentDao.update(testComment);

        Assert.assertEquals(testComment, commentDao.findById(-1));
    }*/

    @Test
    public void delete() {
        commentDao.delete(-1);
        Assert.assertNull(commentDao.findById(-1));
    }
}