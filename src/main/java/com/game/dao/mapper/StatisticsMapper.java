package com.game.dao.mapper;

import com.game.domain.Statistics;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsMapper implements Mapper<Statistics> {

    @Override
    public Statistics map(ResultSet resultSet) throws SQLException {

        return Statistics.builder()
                .withJudge(resultSet.getString("judge"))
                .withTeam(resultSet.getString("team"))
                .withPlayersAmount(resultSet.getInt("players_amount"))
                .withWinner(resultSet.getString("winner"))
                .build();
    }
}
