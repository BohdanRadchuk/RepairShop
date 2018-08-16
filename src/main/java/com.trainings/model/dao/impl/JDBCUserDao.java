package com.trainings.model.dao.impl;

import com.trainings.model.dao.UserDao;
import com.trainings.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCUserDao implements UserDao {
    Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(Integer id) {
        final String sqlQuery = "SELECT name, email FROM watch_repair.user where id_user=?;";
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user.setFirstName(rs.getString(1));
                user.setEmail(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
