package com.game.service;

import com.game.dao.UserDao;
import com.game.domain.User;

import java.util.Optional;

import static com.game.util.EncryptionUtils.encrypt;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User register(User user) {
        user.setPassword(encrypt(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
