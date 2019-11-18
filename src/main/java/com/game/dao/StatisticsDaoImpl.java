package com.game.dao;

import com.game.dao.mapper.Mapper;
import com.game.dao.mapper.StatisticsMapper;
import com.game.domain.Statistics;
import com.game.exception.DatabaseRuntimeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StatisticsDaoImpl extends AbstractDao<Statistics> implements StatisticsDao {

    @Override
    protected Mapper<Statistics> getMapper() {
        return new StatisticsMapper();
    }

    @Override
    public List<Statistics> findPaginated(Integer page, Integer pageSize) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(getSql("select.paginated.statistics"))) {
            statement.setInt(1, (page * pageSize));
            statement.setInt(2, pageSize);
            ResultSet resultSet = statement.executeQuery();

            return constructMultivaluedResult(resultSet);
        } catch (SQLException e) {
            throw new DatabaseRuntimeException(e, "Finding statistics operation exception!");
        }
    }
}
