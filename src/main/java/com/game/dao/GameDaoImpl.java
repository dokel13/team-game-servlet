package com.game.dao;

import com.game.dao.mapper.GameMapper;
import com.game.dao.mapper.Mapper;
import com.game.domain.Game;
import com.game.exception.GameSQLRuntimeException;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class GameDaoImpl extends AbstractDao<Game> implements GameDao {

    @Override
    protected Mapper<Game> getMapper() {
        return new GameMapper();
    }

    @Override
    public Game save(Game game) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(getSql("insert.game"),
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, game.getJudge());
            statement.setBoolean(2, game.getActivity());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                Integer generatedId = resultSet.getInt(1);
                game.setId(generatedId);
            }
            return game;
        } catch (SQLException e) {
            throw new GameSQLRuntimeException(e, "Game saving operation exception!");
        }
    }

    @Override
    public Optional<Game> findById(Integer id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(getSql("select.game.by.id"))) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            return constructResult(resultSet);
        } catch (SQLException e) {
            throw new GameSQLRuntimeException(e, "Game finding by id operation exception!");
        }
    }

    @Override
    public Optional<List<Game>> findAllActive() {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(getSql("select.active.games"))) {
            ResultSet resultSet = statement.executeQuery();

            return constructMultivaluedResult(resultSet);
        } catch (SQLException e) {
            throw new GameSQLRuntimeException(e, "Finding all active games operation exception!");
        }
    }
}
