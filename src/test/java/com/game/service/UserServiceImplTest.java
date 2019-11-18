package com.game.service;

import com.game.dao.UserDao;
import com.game.domain.Role;
import com.game.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.game.util.EncryptionUtils.encrypt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    private final User user = User.builder()
            .withLogin("name")
            .withPassword("_M�;Z�e�\u001D�'\u07B8�ϙ")
            .withRole(Role.PLAYER)
            .build();

    @Test
    public void registerShouldReturnUser() {
        User userActual = User.builder()
                .withLogin("name")
                .withPassword("password")
                .withRole(Role.PLAYER)
                .build();
        when(userDao.save(user)).thenReturn(user);
        assertThat(userService.register(userActual), is(user));
    }

    @Test
    public void findByLoginShouldReturnOptional() {
        when(userDao.findByLogin(user.getLogin())).thenReturn(Optional.of(user));
        assertThat(userService.findByLogin(user.getLogin()), is(Optional.of(user)));
    }
}