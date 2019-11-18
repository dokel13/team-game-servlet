package com.game.controller.command;

import com.game.service.GameService;
import com.game.utiltest.TestHttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayerHomeCommandTest {

    @Mock
    private HttpSession session;

    @Mock
    private GameService gameService;

    @InjectMocks
    private PlayerHomeCommand playerHomeCommand;

    @Test
    public void executeShouldReturnPlayerHomePage() {
        when(gameService.findAllActiveGames()).thenReturn(new ArrayList<>());
        when(gameService.findAllStatistics(any(Integer.class), any(Integer.class)))
                .thenReturn(new ArrayList<>());

        assertThat(playerHomeCommand.execute(new TestHttpServletRequest().getRequest(session)),
                is("/WEB-INF/jsp/player/home.jsp"));

        verify(gameService).findAllActiveGames();
        verify(gameService).findAllStatistics(any(Integer.class), any(Integer.class));
    }
}