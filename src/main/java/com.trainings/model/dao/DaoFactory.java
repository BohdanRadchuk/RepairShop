package com.trainings.model.dao;

import com.trainings.model.dao.impl.JDBCDaoFactory;
import com.trainings.model.dao.impl.JDBCUserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DaoFactory {
    //private DataSource dataSource = ConnectionPoolHolder.getDataSource();
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();


    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }


    /*private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
