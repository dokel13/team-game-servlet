package com.game.controller.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameConfigCommandTest {

    HttpServletRequest request;

    @Test
    public void executeShouldReturnGamePage() {
        assertThat(new GameConfigCommand().execute(request), is("/WEB-INF/jsp/player/game.jsp"));
    }
}