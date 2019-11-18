package com.game.controller.command;

import com.game.domain.Role;
import com.game.utiltest.TestHttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeCommandTest {

    @Mock
    private HttpSession session;

    private final HomeCommand homeCommand = new HomeCommand();

    @Test
    public void executeShouldReturnJudgePage() {
        when(session.getAttribute("role")).thenReturn(Role.JUDGE);

        assertThat(homeCommand.execute(new TestHttpServletRequest().getRequest(session)),
                is("redirect:/game/api/judge"));

        verify(session).getAttribute("role");
    }

    @Test
    public void executeShouldReturnPlayerPage() {
        when(session.getAttribute("role")).thenReturn(Role.PLAYER);

        assertThat(homeCommand.execute(new TestHttpServletRequest().getRequest(session)),
                is("redirect:/game/api/player"));

        verify(session).getAttribute("role");
    }

    @Test
    public void executeShouldReturnHomePage() {
        when(session.getAttribute("role")).thenReturn(null);

        assertThat(homeCommand.execute(new TestHttpServletRequest().getRequest(session)),
                is("/WEB-INF/jsp/home.jsp"));

        verify(session).getAttribute("role");
    }
}