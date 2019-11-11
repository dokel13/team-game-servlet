package com.game.dao;

import com.game.dao.mapper.Mapper;
import com.game.dao.mapper.UserMapper;
import com.game.domain.User;
import com.game.exception.UserSQLRuntimeException;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    protected Mapper<User> getMapper() {
        return new UserMapper();
    }

    @Override
    public User save(User user) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     getSql("insert.user"), Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().name());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                Integer generatedId = resultSet.getInt(1);
                user.setId(generatedId);
            }
            return user;
        } catch (SQLException e) {
            throw new UserSQLRuntimeException(e, "User saving operation exception!");
        }
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(getSql("select.user.by.login"))) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            return constructResult(resultSet);
        } catch (SQLException e) {
            throw new UserSQLRuntimeException(e, "User finding by login operation exception!");
        }
    }
}
