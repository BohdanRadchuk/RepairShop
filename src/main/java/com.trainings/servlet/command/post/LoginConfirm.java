package com.trainings.servlet.command.post;


import com.trainings.model.dao.ConnectionPoolHolder;
import com.trainings.model.dao.DaoFactory;
import com.trainings.model.dao.UserDao;
import com.trainings.model.dao.impl.JDBCDaoFactory;
import com.trainings.model.dao.impl.JDBCUserDao;
import com.trainings.model.entity.User;
import com.trainings.servlet.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginConfirm implements ServletCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao dao = daoFactory.createUserDao();
        User user = dao.findById(1);
        System.out.println(user + " user in servlet");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        System.out.println(email + "email");
        try ( Connection connection = ConnectionPoolHolder.getDataSource().getConnection()){
            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //check in db

        return "";
    }
}
