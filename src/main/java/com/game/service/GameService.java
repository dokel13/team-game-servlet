package com.game.service;

import com.game.domain.Game;
import com.game.domain.Statistics;

import java.util.List;
import java.util.Optional;

public interface GameService {

    Game create(Game game);

    Optional<Game> findById(Integer id);

    List<Game> findAllActive();

    List<Statistics> findAllStatistics();
}
