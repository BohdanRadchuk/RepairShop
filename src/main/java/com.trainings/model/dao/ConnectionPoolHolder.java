package com.trainings.model.dao;

import com.trainings.constant.ConnectionProperty;
import com.trainings.model.entity.*;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
                        property.load( new FileInputStream(ConnectionProperty.PROPERTY_PATH));
                        ds.setDriverClassName(property.getProperty(ConnectionProperty.DRIVER));
                        ds.setUrl(property.getProperty(ConnectionProperty.HOST));
                        ds.setUsername(property.getProperty(ConnectionProperty.LOGIN));
                        ds.setPassword(property.getProperty(ConnectionProperty.PASSWORD));
                        ds.setMinIdle(Integer.parseInt(property.getProperty(ConnectionProperty.MIN_IDLE)));
                        ds.setMaxIdle(Integer.parseInt(property.getProperty(ConnectionProperty.MAX_IDLE)));
                        ds.setMaxOpenPreparedStatements(Integer.parseInt(property
                                .getProperty(ConnectionProperty.MAX_STATEMENT)));
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
   /* private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static void main(String[] args) throws SQLException {
        /*UserDao daoFactory = DaoFactory.getInstance().createUserDao();
        System.out.println(daoFactory.findById(1));
        System.out.println(daoFactory.findAll());
        System.out.println(daoFactory.create(new User.UserBuilder()
                .name("name")
                .surname("surname")
                .email("email3")
                .password("password")
                .role(Role.USER)
                .build()));

        System.out.println(daoFactory.update(new User.UserBuilder()
                .userId(9)
                .name("name2")
                .surname("surname2")
                .email("email@2")
                .password("password2")
                .role(Role.ADMIN)
                .build()));
        System.out.println(daoFactory.findByEmail("email@2"));
        System.out.println(daoFactory.delete(9));
        System.out.println(daoFactory.findAll());*/
        /*
        JDBCUserDao j = new JDBCUserDao(dataSource.getConnection());
        System.out.println(j.findById(1));*/

        /*OrderDao dao = DaoFactory.getInstance().createOrderDao();
        System.out.println(dao.findById(1));
        Order o = new Order(3, 1, Status.DONE);
        o.setDoneDate(LocalDateTime.now());
        dao.create(o);*/

        CommentDao dao1 = DaoFactory.getInstance().createCommentDao();
        dao1.create(new Comment(2, "asddd"));
    }

}
