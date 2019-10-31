package com.game.service;

import com.game.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByLogin(String login);

    User createUser(User user);
}
