package com.trainings.model.dao.impl;

import com.trainings.model.dao.CommentDao;
import com.trainings.model.dao.factory.DaoFactory;
import com.trainings.model.entity.Comment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class JDBCCommentDaoTest {

    private int ID = 5;
    private final static String COMMENTARY = "test comment";
    private CommentDao commentDao;
    private Comment testComment;

    @Before
    public void setUp() throws Exception {
        commentDao = DaoFactory.getInstance().createCommentDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createTest() {
        testComment = new Comment(ID, COMMENTARY);
        commentDao.create(testComment);
        List<Comment> comments = commentDao.findAll();
        Assert.assertEquals(comments.get(comments.size() - 1), testComment);
        commentDao.delete(ID);
    }

    @Test
    public void findByIdTest() {
        Assert.assertFalse(commentDao.findById(ID).isPresent());
        testComment = new Comment(ID, COMMENTARY);
        commentDao.create(testComment);
        List<Comment> comments = commentDao.findAll();
        Assert.assertEquals(comments.get(comments.size() - 1), testComment);
        int id = comments.get(comments.size() - 1).getIdOrder();
        Assert.assertEquals(testComment, commentDao.findById(id).get());
        commentDao.delete(ID);
    }

    @Test
    public void findAllTest() {
        int sizeAllTable = commentDao.findAll().size();
        testComment = new Comment(ID, COMMENTARY);
        commentDao.create(testComment);
        List<Comment> comments = commentDao.findAll();
        Assert.assertEquals(comments.size(), sizeAllTable + 1);
        Assert.assertEquals(comments.get(comments.size() - 1), testComment);
        commentDao.delete(ID);
    }

    @Test
    public void updateTest() {
        testComment = new Comment(ID, COMMENTARY);
        commentDao.create(testComment);
        Comment comment = new Comment(ID, "newComment");
        commentDao.update(comment);
        Assert.assertEquals(comment.getCommentary(), commentDao.findById(ID).get().getCommentary());
        commentDao.delete(ID);
    }

    @Test
    public void deleteTest() {
        int size = commentDao.findAll().size();
        testComment = new Comment(ID, COMMENTARY);
        commentDao.create(testComment);
        int newSize = commentDao.findAll().size();
        Assert.assertEquals((size + 1), newSize);

        boolean deleted = commentDao.delete(ID);
        Assert.assertTrue(deleted);
        Assert.assertFalse(commentDao.findById(ID).isPresent());
        Assert.assertEquals(size, commentDao.findAll().size());
    }
}