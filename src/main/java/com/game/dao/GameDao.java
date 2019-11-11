package com.game.dao;

import com.game.domain.Game;
import com.game.domain.Statistics;

import java.util.List;
import java.util.Optional;

public interface GameDao {

    Optional<Game> findById(Integer id);

    Game save(Game game);

    Optional<List<Game>> findAllActive();
}
