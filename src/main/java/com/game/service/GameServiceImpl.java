package com.game.service;

import com.game.dao.GameDao;
import com.game.dao.QuestionDao;
import com.game.dao.StatisticsDao;
import com.game.domain.Game;
import com.game.domain.Question;
import com.game.domain.Statistics;

import java.util.List;
import java.util.Optional;

public class GameServiceImpl implements GameService {

    private GameDao gameDao;

    private StatisticsDao statisticsDao;

    private QuestionDao questionDao;

    public GameServiceImpl(GameDao gameDao, StatisticsDao statisticsDao, QuestionDao questionDao) {
        this.gameDao = gameDao;
        this.statisticsDao = statisticsDao;
        this.questionDao = questionDao;
    }

    @Override
    public Game create(Game game) {
        return gameDao.save(game);
    }

    @Override
    public Optional<Game> findGameById(Integer id) {
        return gameDao.findById(id);
    }

    @Override
    public List<Game> findAllActiveGames() {
        return gameDao.findAllActive();
    }

    @Override
    public List<Statistics> findAllStatistics(Integer page, Integer pageSize) {
        return statisticsDao.findPaginated(page, pageSize);
    }

    @Override
    public List<Question> findRandomQuestions(Integer amount) {
        return questionDao.findRandom(amount);
    }
}
