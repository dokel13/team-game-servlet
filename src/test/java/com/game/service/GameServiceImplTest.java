package com.game.service;

import com.game.dao.GameDao;
import com.game.dao.StatisticsDao;
import com.game.domain.Game;
import com.game.domain.Statistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceImplTest {

    @Mock
    private GameDao gameDao;

    @Mock
    private StatisticsDao statisticsDao;

    @InjectMocks
    private GameServiceImpl gameService;

    private final Game game = Game.builder()
            .withId(3)
            .withJudge("judge")
            .withActivity(true)
            .build();

    private final List<Game> games = Arrays.asList(game, game, game);

    private final List<Statistics> statistics = new ArrayList<>();

    @Test
    public void createShouldReturnGame() {
        when(gameDao.save(any(Game.class))).thenReturn(game);
        Game gameActual = gameService.create(game);
        assertThat(gameActual, is(game));
    }

    @Test
    public void findByIdShouldReturnOptional() {
        when(gameDao.findById(game.getId())).thenReturn(Optional.of(game));
        assertThat(gameService.findGameById(game.getId()), is(Optional.of(game)));
    }

    @Test
    public void findAllActiveShouldReturnGamesList() {
        when(gameDao.findAllActive()).thenReturn(games);
        assertThat(gameService.findAllActiveGames(), is(games));
    }

    @Test
    public void findAllStatisticsShouldReturnStatisticsList() {
        when(statisticsDao.findPaginated(any(Integer.class), any(Integer.class))).thenReturn(statistics);
        assertThat(gameService.findAllStatistics(3, 4), is(statistics));
    }
}