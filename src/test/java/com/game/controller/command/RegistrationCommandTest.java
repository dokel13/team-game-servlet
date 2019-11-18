package com.game.controller.command;

import com.game.domain.Role;
import com.game.domain.User;
import com.game.exception.RegistrationRuntimeException;
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
public class RegistrationCommandTest {

    @Mock
    HttpSession session;

    @Mock
    UserService userService;

    @InjectMocks
    private RegistrationCommand registrationCommand;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private TestHttpServletRequest testRequest = new TestHttpServletRequest();

    {
        testRequest.setParameter("login", "login");
        testRequest.setParameter("password", "password");
        testRequest.setQueryString("query");
    }

    @Test
    public void executeShouldReturnPlayerPage() {
        when(userService.findByLogin(any(String.class))).thenReturn(Optional.
                empty());

        assertThat(registrationCommand.execute(testRequest.getRequest(session)),
                is("redirect:/game/api/player?" + testRequest.getQueryString()));

        verify(userService).findByLogin(any(String.class));
        verify(session).setAttribute("role", Role.PLAYER);
        verify(session).setAttribute("login", "login");
    }

    @Test
    public void executeShouldThrowException() {
        expectedException.expect(RegistrationRuntimeException.class);
        expectedException.expectMessage("User already exists!");

        when(userService.findByLogin(any(String.class))).thenReturn(Optional.
                of(User.builder().build()));

        registrationCommand.execute(testRequest.getRequest(session));

        verify(userService).findByLogin(any(String.class));
    }
}