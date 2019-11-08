package com.game.dao.mapper;

import com.game.domain.Game;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements Mapper<Game> {

    @Override
    public Game map(ResultSet resultSet) throws SQLException {

        return Game.builder()
                .withId(resultSet.getInt("game_id"))
                .withJudge(resultSet.getString("judge"))
                .withActivity(resultSet.getBoolean("activity"))
                .build();
    }
}
