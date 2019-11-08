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
                .withCaptain(resultSet.getString("captain"))
                .withRightAnswers(resultSet.getInt("right_answers"))
                .withWrongAnswers(resultSet.getInt("wrong_answer"))
                .withWinner(resultSet.getString("winner"))
                .build();
    }
}
