package com.game.dao;

import com.game.domain.Game;

import java.util.List;
import java.util.Optional;

public interface GameDao {

    Optional<Game> findById(Integer id);

    Game save(Game game);

    List<Game> findAllActive();
}
