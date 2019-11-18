package com.game.dao.mapper;

import com.game.domain.Game;
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
public class GameMapperTest {

    @Mock
    private ResultSet resultSet;

    private final GameMapper gameMapper = new GameMapper();

    private final Game game = Game.builder()
            .withId(1)
            .withJudge("judge")
            .withActivity(true)
            .build();

    @Test
    public void mapShouldReturnGame() {
        try {
            when(resultSet.getInt("game_id")).thenReturn(1);
            when(resultSet.getString("judge")).thenReturn("judge");
            when(resultSet.getBoolean("active")).thenReturn(true);
            assertThat(gameMapper.map(resultSet), is(game));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}