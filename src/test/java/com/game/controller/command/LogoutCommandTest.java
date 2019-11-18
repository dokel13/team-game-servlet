package com.game.controller.command;

import com.game.utiltest.TestHttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogoutCommandTest {

    @Mock
    private HttpSession session;

    private LogoutCommand logoutCommand = new LogoutCommand();

    @Test
    public void executeShouldReturnHomePage() {
        assertThat(logoutCommand.execute(new TestHttpServletRequest().getRequest(session)),
                is("redirect:/game/api/home"));

        verify(session).invalidate();
    }
}