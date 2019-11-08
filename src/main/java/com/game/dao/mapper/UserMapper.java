package com.game.dao.mapper;

import com.game.domain.Role;
import com.game.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {

        return User.builder()
                .withLogin(resultSet.getString("login"))
                .withPassword(resultSet.getString("password"))
                .withRole(Role.valueOf(resultSet.getString("role")))
                .build();
    }
}
