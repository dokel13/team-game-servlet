package com.game.dao;

import com.game.domain.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findByLogin(String login);

    User save(User user);
}
