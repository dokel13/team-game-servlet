package com.game.service;

import com.game.domain.User;
import com.game.dao.UserDao;
import com.game.util.EncryptionUtils;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(EncryptionUtils.encrypt(user.getPassword()));
        return userDao.createUser(user);
    }
}
