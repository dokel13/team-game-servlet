package com.game.dao.mapper;

import com.game.domain.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements Mapper<Question> {

    @Override
    public Question map(ResultSet resultSet) throws SQLException {

        return Question.builder()
                .withBody(resultSet.getString("body"))
                .withAnswer(resultSet.getString("answer"))
                .withHelp(resultSet.getString("help"))
                .withSecond_answer(resultSet.getString("second_answer"))
                .withThird_answer(resultSet.getString("third_answer"))
                .withFourth_answer(resultSet.getString("fourth_answer"))
                .withAuthor(resultSet.getString("author"))
                .build();
    }
}
