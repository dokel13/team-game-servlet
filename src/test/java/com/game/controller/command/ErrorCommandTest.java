package com.game.controller.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;

public class ErrorCommandTest {

    @Test
    public void executeShouldReturnErrorPage() {
        assertThat(new ErrorCommand().execute(any(HttpServletRequest.class)),
                is("/WEB-INF/jsp/error.jsp"));
    }
}