package com.trainings.model.dao.mapper;

import com.trainings.model.entity.Role;
import com.trainings.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_user");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email =  rs.getString("email");
        String password = rs.getString("password");
        Role role = Role.valueOf(rs.getString("role"));


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
