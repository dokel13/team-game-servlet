package com.game.dao;

import com.game.domain.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUserByLogin(String login);

    User createUser(User user);
}
