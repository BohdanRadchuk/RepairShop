package com.trainings.model.dao.mapper;

import com.trainings.constant.ColumnName;
import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.USER_ID);
        String name = rs.getString(ColumnName.USER_NAME);
        String surname = rs.getString(ColumnName.USER_SURNAME);
        String email =  rs.getString(ColumnName.USER_EMAIL);
        String password = rs.getString(ColumnName.USER_PASSWORD);
        Role role = Role.valueOf(rs.getString(ColumnName.USER_ROLE));

        return new User.UserBuilder()
                .userId(id)
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User teacher) {
        return null;
    }
}
