package com.game.service;

import com.game.dao.GameDao;
import com.game.domain.Game;
import com.game.domain.Statistics;

import java.util.List;
import java.util.Optional;

public class GameServiceImpl implements GameService {

    private GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public Game create(Game game) {
        return gameDao.save(game);
    }

    @Override
    public Optional<Game> findById(Integer id) {
        return gameDao.findById(id);
    }

    @Override
    public List<Game> findAllActive() {
        return gameDao.findAllActive();
    }

    @Override
    public List<Statistics> findAllStatistics() {
        return gameDao.findAllStatistics();
    }
}
