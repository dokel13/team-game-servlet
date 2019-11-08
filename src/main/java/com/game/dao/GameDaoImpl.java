package com.game.dao;

import com.game.dao.datasource.ConnectionPool;
import com.game.dao.mapper.GameMapper;
import com.game.dao.mapper.StatisticsMapper;
import com.game.domain.Game;
import com.game.domain.Statistics;
import com.game.exception.GameSQLRuntimeException;

import java.sql.*;
import java.util.*;

public class GameDaoImpl implements GameDao {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final GameMapper gameMapper = new GameMapper();

    private final StatisticsMapper statisticsMapper = new StatisticsMapper();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("queries");

    @Override
    public Game save(Game game) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(resourceBundle.getString("insert.game"),
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, game.getJudge());
            statement.setBoolean(2, game.getActivity());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer generatedId = resultSet.getInt(1);
                game.setId(generatedId);
            } else {
                throw new SQLException();
            }
            return game;
        } catch (SQLException e) {
            throw new GameSQLRuntimeException(e, "Game saving operation exception!");
        }
    }

    @Override
    public Optional<Game> findById(Integer id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(resourceBundle.getString("select.game.by.id"))) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(gameMapper.map(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new GameSQLRuntimeException(e, "Game finding by id operation exception!");
        }
    }

    @Override
    public List<Game> findAllActive() {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(resourceBundle.getString("select.active.games"))) {
            ResultSet resultSet = statement.executeQuery();
            List<Game> games = new ArrayList<>();
            while (resultSet.next()) {
                games.add(gameMapper.map(resultSet));
            }
            return games;
        } catch (SQLException e) {
            throw new GameSQLRuntimeException(e, "Finding all active games operation exception!");
        }
    }

    @Override
    public List<Statistics> findAllStatistics() {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(resourceBundle.getString("select.statistics"))) {
            ResultSet resultSet = statement.executeQuery();
            List<Statistics> statistics = new ArrayList<>();
            while (resultSet.next()) {
                statistics.add(statisticsMapper.map(resultSet));
            }
            return statistics;
        } catch (SQLException e) {
            throw new GameSQLRuntimeException(e, "Finding all statistics operation exception!");
        }
    }
}
