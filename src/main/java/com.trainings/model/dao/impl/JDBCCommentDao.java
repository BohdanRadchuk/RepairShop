package com.trainings.model.dao.impl;

import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.CommentDao;
import com.trainings.model.entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCCommentDao implements CommentDao {
    private Connection connection;


    public JDBCCommentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Comment comment) {
        try (PreparedStatement ps = newCommentPrepareStatement(comment)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private PreparedStatement newCommentPrepareStatement(Comment comment) throws SQLException {
        String sqlQuery = SqlQuery.COMMENT_CREATE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, comment.getIdOrder());
        ps.setString(2, comment.getCommentary());
        return ps;
    }

    @Override
    public Optional<Comment> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public boolean update(Comment entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
