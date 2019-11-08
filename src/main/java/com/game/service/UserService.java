package com.game.service;

import com.game.domain.User;

import java.util.Optional;

public interface UserService {

    User register(User user);

    Optional<User> findByLogin(String login);
}
