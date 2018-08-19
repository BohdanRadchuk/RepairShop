package com.trainings.model.dao.impl;

import com.trainings.model.dao.UserDao;
import com.trainings.model.dao.mapper.UserMapper;
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
    private UserMapper userMapper = new UserMapper();

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(final User entity) {
        return true;
    }

    @Override
    public Optional<User> findById(final Integer id) {
        Optional<User> user = Optional.empty();

        try (PreparedStatement ps = createFindByUniqueParamPrepareStatement(id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                user = Optional.ofNullable(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }




    @Override
    public List<User> findAll() {
        final String sqlQuery = "SELECT * FROM watch_repair.user;";
        List<User> users = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                users.add(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(final User entity) {
        return true;
    }

    @Override
    public boolean delete(final Integer id) {
        return true;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.empty();

        try (PreparedStatement ps = createFindByUniqueParamPrepareStatement(email);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                user = Optional.ofNullable(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    private PreparedStatement createFindByUniqueParamPrepareStatement(final Integer id) throws SQLException {
        final String sqlQuery = "SELECT * FROM watch_repair.user WHERE id_user=?;";
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    private PreparedStatement createFindByUniqueParamPrepareStatement(String email) throws SQLException {
        final String sqlQuery = "SELECT * FROM watch_repair.user WHERE email=?;";
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, email);
        return ps;
    }


}
