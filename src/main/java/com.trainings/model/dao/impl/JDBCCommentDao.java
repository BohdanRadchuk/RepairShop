package com.trainings.model.dao.impl;

import com.trainings.constant.ColumnName;
import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.CommentDao;
import com.trainings.model.entity.Comment;

import java.sql.*;
import java.util.ArrayList;
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
        Optional<Comment> comment = Optional.empty();

        try (PreparedStatement ps = findByIDPrepareStatement(id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                comment = Optional.of(getCommentFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;

    }

    @Override
    public List<Comment> findAll() {
        String sqlQuery = SqlQuery.COMMENT_GET_ALL;
        List<Comment> comments = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {
            while (rs.next()) {
                comments.add(getCommentFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    private Comment getCommentFromResultSet(ResultSet rs) throws SQLException {
        return new Comment(rs.getInt(ColumnName.ORDER_ID), rs.getString(ColumnName.COMMENT_COMMENTARY));
    }

    @Override
    public boolean update(Comment comment) {
        try (PreparedStatement ps = updateServicePrepareStatement(comment)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        try (PreparedStatement ps = deleteCommentPrepareStatement(id)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private PreparedStatement findByIDPrepareStatement(int id) throws SQLException {
        String sqlQuery = SqlQuery.COMMENT_GET_BY_ORDER_ID;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    private PreparedStatement deleteCommentPrepareStatement(int id) throws SQLException {
        String sqlQuery = SqlQuery.COMMENT_DELETE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    private PreparedStatement updateServicePrepareStatement(Comment comment) throws SQLException {
        String sqlQuery = SqlQuery.COMMENT_UPDATE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, comment.getCommentary());
        ps.setInt(2, comment.getIdOrder());
        return ps;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
