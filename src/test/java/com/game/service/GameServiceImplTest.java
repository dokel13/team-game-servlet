package com.game.service;

import com.game.dao.GameDao;
import com.game.domain.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceImplTest {

    @Mock
    GameDao gameDao;

    @InjectMocks
    GameServiceImpl gameService;

    private final Game game = Game.builder()
            .withId(3)
            .withJudge("judge")
            .withActivity(true)
            .build();

    @Test
    public void createShouldReturnGame() {
        when(gameDao.save(any(Game.class))).thenReturn(game);
        Game gameActual = gameService.create(game);
        assertThat(gameActual, is(game));
    }

    @Test
    public void findByIdShouldReturnOptional() {
        when(gameDao.findById(game.getId())).thenReturn(Optional.of(game));
        assertThat(gameService.findById(game.getId()), is(Optional.of(game)));
    }

    @Test
    public void findAllActive() {
    }

    @Test
    public void findAllStatistics() {
    }
}