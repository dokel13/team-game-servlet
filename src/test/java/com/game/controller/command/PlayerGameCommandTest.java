package com.game.controller.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class PlayerGameCommandTest {

    @Test
    public void executeShouldReturnPlayerGamePage() {
        assertThat(new PlayerGameCommand().execute(any(HttpServletRequest.class)),
                is("/WEB-INF/jsp/player/game.jsp"));
    }
}