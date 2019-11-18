package com.game.dao;

import com.game.dao.datasource.ConnectionPool;
import com.game.dao.mapper.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class AbstractDao<T> {

    private final ConnectionPool connectionPool = new ConnectionPool("database");

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("queries");

    protected abstract Mapper<T> getMapper();

    protected Connection getConnection() {
        return connectionPool.getConnection();
    }

    protected String getSql(String queryName) {
        return resourceBundle.getString(queryName);
    }

    protected List<T> constructMultivaluedResult(ResultSet resultSet) throws SQLException {
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(getMapper().map(resultSet));
        }
        return result;
    }

    protected Optional<T> constructResult(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(getMapper().map(resultSet));
        }
        return Optional.empty();
    }
}
