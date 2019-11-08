package com.game.dao;

import com.game.dao.datasource.ConnectionPool;
import com.game.dao.mapper.UserMapper;
import com.game.domain.User;
import com.game.exception.UserSQLRuntimeException;

import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserDaoImpl implements UserDao {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final UserMapper userMapper = new UserMapper();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("queries");

    @Override
    public User save(User user) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(resourceBundle
                     .getString("insert.user"), Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().name());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer generatedId = resultSet.getInt(1);
                user.setId(generatedId);
            } else {
                throw new SQLException();
            }
            return user;
        } catch (SQLException e) {
            throw new UserSQLRuntimeException(e, "User saving operation exception!");
        }
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(resourceBundle
                     .getString("select.user.by.login"))) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return Optional.of(userMapper.map(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new UserSQLRuntimeException(e, "User finding by login operation exception!");
        }
    }
}
