package com.game.dao.mapper;

import com.game.domain.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionMapperTest {

    @Mock
    private ResultSet resultSet;

    private final QuestionMapper questionMapper = new QuestionMapper();

    private final Question question = Question.builder()
            .withBody("body")
            .withAnswer("answer")
            .withHelp("help")
            .withSecond_answer("second_answer")
            .withThird_answer("third_answer")
            .withFourth_answer("fourth_answer")
            .withAuthor("author")
            .build();

    @Test
    public void mapShouldReturnQuestion() {
        try {
            when(resultSet.getString("body")).thenReturn("body");
            when(resultSet.getString("answer")).thenReturn("answer");
            when(resultSet.getString("help")).thenReturn("help");
            when(resultSet.getString("second_answer")).thenReturn("second_answer");
            when(resultSet.getString("third_answer")).thenReturn("third_answer");
            when(resultSet.getString("fourth_answer")).thenReturn("fourth_answer");
            when(resultSet.getString("author")).thenReturn("author");
            assertThat(questionMapper.map(resultSet), is(question));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}