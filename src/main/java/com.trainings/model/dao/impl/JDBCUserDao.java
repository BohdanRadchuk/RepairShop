package com.trainings.model.dao.impl;

import com.trainings.model.dao.UserDao;
import com.trainings.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(User entity) {
        return true;
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> user = Optional.empty();

        try (PreparedStatement ps = createFindByUniqueParamPrepareStatement(id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                user = Optional.ofNullable(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setEmail("email");
        user.setSurname(rs.getString(1));
        user.setEmail(rs.getString(2));

        return user;
    }


    @Override
    public List<User> findAll() {
        final String sqlQuery = "SELECT  watch_repair.user;";
        List<User> users = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                users.add(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(User entity) {
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return true;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.empty();

        try (PreparedStatement ps = createFindByUniqueParamPrepareStatement(email);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                user = Optional.ofNullable(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    private PreparedStatement createFindByUniqueParamPrepareStatement(Integer id) throws SQLException {
        final String sqlQuery = "SELECT name, email FROM watch_repair.user WHERE id_user=?;";
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    private PreparedStatement createFindByUniqueParamPrepareStatement(String email) throws SQLException {
        final String sqlQuery = "SELECT name, email FROM watch_repair.user WHERE email=?;";
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, email);
        return ps;
    }


}
