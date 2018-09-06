package com.trainings.model.dao.mapper;

import com.trainings.constant.ColumnName;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractOrderFromResultSet(ResultSet rs) throws SQLException {
        return new User.UserBuilder()
                .userId(rs.getInt(ColumnName.USER_ID))
                .name(rs.getString(ColumnName.USER_NAME))
                .surname(rs.getString(ColumnName.USER_SURNAME))
                .email(rs.getString(ColumnName.USER_EMAIL))
                .password(rs.getString(ColumnName.USER_PASSWORD))
                .role(Role.valueOf(rs.getString(ColumnName.USER_ROLE)))
                .build();
    }
}
