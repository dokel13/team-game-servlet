package com.game.dao;

import com.game.domain.User;
import com.game.dao.datasource.ConnectionPool;
import com.game.util.SqlQueryRetriever;
import com.game.dao.mapper.UserMapper;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final SqlQueryRetriever sqlQueryRetriever = SqlQueryRetriever.getInstance();
    private final UserMapper userMapper = new UserMapper();

    @Override
    public Optional<User> getUserByLogin(String login) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sqlQueryRetriever.getQuery(SqlQueryRetriever.Query.SELECT_USER_BY_LOGIN))) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            return userMapper.map(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User createUser(User user) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sqlQueryRetriever.getQuery(SqlQueryRetriever.Query.INSERT_USER), Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().name());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                Long generatedId = resultSet.getLong(1);
                user.setId(generatedId);
            } else {
                throw new SQLException();
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
