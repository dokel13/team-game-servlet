package com.game.service;

import com.game.dao.GameDao;
import com.game.dao.StatisticsDao;
import com.game.domain.Game;
import com.game.domain.Statistics;

import java.util.List;
import java.util.Optional;

public class GameServiceImpl implements GameService {

    private GameDao gameDao;

    private StatisticsDao statisticsDao;

    public GameServiceImpl(GameDao gameDao, StatisticsDao statisticsDao) {
        this.gameDao = gameDao;
        this.statisticsDao = statisticsDao;
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
        return gameDao.findAllActive().get();
    }

    @Override
    public List<Statistics> findAllStatistics(Integer page, Integer pageSize) {
        return statisticsDao.findPaginatedStatistics(page, pageSize).get();
    }
}
