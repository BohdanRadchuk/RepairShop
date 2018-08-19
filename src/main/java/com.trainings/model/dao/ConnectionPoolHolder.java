package com.trainings.model.dao;


import com.trainings.model.dao.impl.JDBCUserDao;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource(){
        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    Properties property = new Properties();
                    try {
                        property.load( new FileInputStream("src/main/resources/connection_info.properties"));
                        ds.setDriverClassName(property.getProperty("db.driver"));
                        ds.setUrl(property.getProperty("db.host"));
                        ds.setUsername(property.getProperty("db.login"));
                        ds.setPassword(property.getProperty("db.password"));
                        ds.setMinIdle(Integer.parseInt(property.getProperty("db.minIdle")));
                        ds.setMaxIdle(Integer.parseInt(property.getProperty("db.maxIdle")));
                        ds.setMaxOpenPreparedStatements(Integer.parseInt(property.getProperty("db.maxStatement")));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dataSource = ds;
                }
            }
        }

        return dataSource;

    }
    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        UserDao daoFactory = DaoFactory.getInstance().createUserDao();
        System.out.println(daoFactory.findById(1));
        /*
        JDBCUserDao j = new JDBCUserDao(dataSource.getConnection());
        System.out.println(j.findById(1));*/
    }

}
