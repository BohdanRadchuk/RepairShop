package com.trainings.model.dao.impl;

import com.trainings.model.dao.ConnectionPoolHolder;
import com.trainings.model.dao.DaoFactory;
import com.trainings.model.dao.ServiceDao;
import com.trainings.model.dao.UserDao;


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
    public ServiceDao createServiceDao() {
        return new JDBCServiceDao(getConnection());
    }

    private Connection getConnection(){
        try {
           return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
