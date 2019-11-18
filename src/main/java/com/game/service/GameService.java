package com.game.service;

import com.game.domain.Game;
import com.game.domain.Question;
import com.game.domain.Statistics;

import java.util.List;
import java.util.Optional;

public interface GameService {

    Game create(Game game);

    Optional<Game> findGameById(Integer id);

    List<Game> findAllActiveGames();

    List<Statistics> findAllStatistics(Integer page, Integer pageSize);

    List<Question> findRandomQuestions(Integer amount);
}
