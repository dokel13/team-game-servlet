package com.game.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface Mapper<T> {

    Optional<T> map(ResultSet resultSet) throws SQLException;
}
