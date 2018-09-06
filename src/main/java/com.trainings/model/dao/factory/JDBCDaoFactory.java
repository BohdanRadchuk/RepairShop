package com.trainings.model.dao.factory;

import com.trainings.model.dao.*;
import com.trainings.model.dao.impl.JDBCCommentDao;
import com.trainings.model.dao.impl.JDBCOrderDao;
import com.trainings.model.dao.impl.JDBCServeDao;
import com.trainings.model.dao.impl.JDBCUserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public ServeDao createServeDao() {
        return new JDBCServeDao(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new JDBCOrderDao(getConnection());
    }

    @Override
    public CommentDao createCommentDao() {
        return new JDBCCommentDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
