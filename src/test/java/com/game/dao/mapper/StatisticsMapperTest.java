package com.game.dao.mapper;

import com.game.domain.Statistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsMapperTest {

    @Mock
    private ResultSet resultSet;

    private final StatisticsMapper statisticsMapper = new StatisticsMapper();

    private final Statistics statistics = Statistics.builder()
            .withJudge("judge")
            .withTeam("team")
            .withPlayersAmount(3)
            .withWinner("winner")
            .build();

    @Test
    public void mapShouldReturnStatistics() {
        try {
            when(resultSet.getString("judge")).thenReturn("judge");
            when(resultSet.getString("team")).thenReturn("team");
            when(resultSet.getInt("players_amount")).thenReturn(3);
            when(resultSet.getString("winner")).thenReturn("winner");
            assertThat(statisticsMapper.map(resultSet), is(statistics));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}