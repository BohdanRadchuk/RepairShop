package com.trainings.model.dao.impl;

import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.UserDao;
import com.trainings.model.dao.mapper.UserMapper;
import com.trainings.model.entity.User;

import java.sql.*;
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
        try (PreparedStatement ps = newUserPrepareStatement(entity)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<User> findById(final Integer id) {
        Optional<User> user = Optional.empty();

        try (PreparedStatement ps = findByUniqueParamPrepareStatement(id);
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
        final String sqlQuery = SqlQuery.USER_GET_ALL;
        List<User> users = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {
            while (rs.next()) {
                users.add(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean update(final User entity) {
        try (PreparedStatement ps = updateUserPrepareStatement(entity)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(final Integer id) {
        try (PreparedStatement ps = deleteUserPrepareStatement(id)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.empty();

        try (PreparedStatement ps = findByUniqueParamPrepareStatement(email);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                user = Optional.ofNullable(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    private PreparedStatement findByUniqueParamPrepareStatement(int id) throws SQLException {
        final String sqlQuery = SqlQuery.USER_GET_BY_ID;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    private PreparedStatement findByUniqueParamPrepareStatement(String email) throws SQLException {
        final String sqlQuery = SqlQuery.USER_GET_BY_EMAIL;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, email);
        return ps;
    }

    private PreparedStatement newUserPrepareStatement(final User user) throws SQLException {
        String sqlQuery = SqlQuery.USER_CREATE;

        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, user.getName());
        ps.setString(2, user.getSurname());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getRole().name());
        return ps;
    }


    private PreparedStatement updateUserPrepareStatement(final User user) throws SQLException {
        String sqlQuery = SqlQuery.USER_UPDATE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, user.getName());
        ps.setString(2, user.getSurname());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getRole().name());
        ps.setInt(6, user.getId());
        return ps;
    }

    private PreparedStatement deleteUserPrepareStatement(int id) throws SQLException {
        String sqlQuery = SqlQuery.USER_DELETE_BY_ID;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

}
