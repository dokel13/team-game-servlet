package com.game.dao.mapper;

import com.game.domain.Role;
import com.game.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserMapper implements Mapper<User> {

    @Override
    public Optional<User> map(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(User.builder()
                    .withLogin(resultSet.getString("login"))
                    .withPassword(resultSet.getString("password"))
                    .withRole(Role.valueOf(resultSet.getString("role")))
                    .build());
        }
        return Optional.empty();
    }
}
