package com.game.controller.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class JudgeHomeCommandTest {

    @Test
    public void executeShouldReturnJudgeHomePage() {
        assertThat(new JudgeHomeCommand().execute(any(HttpServletRequest.class)),
                is("/WEB-INF/jsp/judge/home.jsp"));
    }
}