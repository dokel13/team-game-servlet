package com.game.dao.mapper;

import com.game.domain.Role;
import com.game.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    @Mock
    private ResultSet resultSet;

    private final UserMapper userMapper = new UserMapper();

    private final User user = User.builder()
            .withLogin("login")
            .withPassword("password")
            .withRole(Role.PLAYER)
            .build();

    @Test
    public void mapShouldReturnUser() {
        try {
            when(resultSet.getString("login")).thenReturn("login");
            when(resultSet.getString("password")).thenReturn("password");
            when(resultSet.getString("role")).thenReturn(Role.PLAYER.toString());
            assertThat(userMapper.map(resultSet), is(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}