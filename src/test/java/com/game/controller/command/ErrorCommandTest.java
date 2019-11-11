package com.game.controller.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ErrorCommandTest {

    HttpServletRequest request;

    @Test
    public void executeShouldReturnErrorPage() {
        assertThat(new ErrorCommand().execute(request), is("/WEB-INF/jsp/error.jsp"));
    }
}