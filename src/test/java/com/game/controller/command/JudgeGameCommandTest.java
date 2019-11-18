package com.game.controller.command;

import com.game.domain.Game;
import com.game.service.GameService;
import com.game.utiltest.TestHttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class JudgeGameCommandTest {

    @Mock
    private HttpSession session;

    @Mock
    private GameService gameService;

    @InjectMocks
    private JudgeGameCommand judgeGameCommand;

    @Test
    public void executeShouldReturnJudgeGamePage() {
        assertThat(judgeGameCommand.execute(new TestHttpServletRequest().getRequest(session)),
                is("/WEB-INF/jsp/judge/game.jsp"));

        verify(session).getAttribute("login");
        verify(gameService).create(any(Game.class));
    }
}