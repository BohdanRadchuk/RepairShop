package com.trainings.model.dao.factory;

import com.trainings.model.dao.CommentDao;
import com.trainings.model.dao.OrderDao;
import com.trainings.model.dao.ServeDao;
import com.trainings.model.dao.UserDao;

public abstract class DaoFactory {

    private static volatile DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public abstract ServeDao createServeDao();

    public abstract OrderDao createOrderDao();

    public abstract CommentDao createCommentDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
