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
    public User register(User user) {
        user.setPassword(EncryptionUtils.encrypt(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
