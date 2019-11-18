package com.game.controller.command;

import com.game.domain.Role;
import com.game.domain.User;
import com.game.exception.LoginRuntimeException;
import com.game.service.UserService;
import com.game.utiltest.TestHttpServletRequest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginCommandTest {

    @Mock
    private HttpSession session;

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginCommand loginCommand;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private TestHttpServletRequest testRequest = new TestHttpServletRequest();

    {
        testRequest.setParameter("login", "login");
        testRequest.setParameter("password", "password");
        testRequest.setQueryString("query");
    }

    @Test
    public void executeShouldReturnJudgePage() {
        when(userService.findByLogin(any(String.class))).thenReturn(Optional.of(User.builder()
                .withRole(Role.JUDGE)
                .withPassword("_M�;Z�e�\u001D�'\u07B8�ϙ")
                .build()));

        assertThat(loginCommand.execute(testRequest.getRequest(session)),
                is("redirect:/game/api/judge?" + testRequest.getQueryString()));

        verify(userService).findByLogin(any(String.class));
        verify(session).setAttribute("role", Role.JUDGE);
        verify(session).setAttribute("login", null);
    }

    @Test
    public void executeShouldReturnPlayerPage() {
        when(userService.findByLogin(any(String.class))).thenReturn(Optional.of(User.builder()
                .withRole(Role.PLAYER)
                .withPassword("_M�;Z�e�\u001D�'\u07B8�ϙ")
                .build()));

        assertThat(loginCommand.execute(testRequest.getRequest(session)),
                is("redirect:/game/api/player?" + testRequest.getQueryString()));

        verify(userService).findByLogin(any(String.class));
        verify(session).setAttribute("role", Role.PLAYER);
        verify(session).setAttribute("login", null);
    }

    @Test
    public void executeShouldReturnHomePage() {
        when(userService.findByLogin(any(String.class))).thenReturn(Optional.of(User.builder()
                .withPassword("wrong")
                .build()));

        assertThat(loginCommand.execute(testRequest.getRequest(session)),
                is("redirect:/game/api/home?" + testRequest.getQueryString()));

        verify(userService).findByLogin(any(String.class));
    }

    @Test
    public void executeShouldThrowException() {
        expectedException.expect(LoginRuntimeException.class);
        expectedException.expectMessage("User doesn't exist!");

        loginCommand.execute(new TestHttpServletRequest().getRequest(session));

        verify(userService).findByLogin(any(String.class));
    }
}