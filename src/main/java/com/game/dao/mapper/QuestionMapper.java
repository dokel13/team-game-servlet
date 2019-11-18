package com.game.dao.mapper;

import com.game.domain.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements Mapper<Question> {

    @Override
    public Question map(ResultSet resultSet) throws SQLException {

        return Question.builder()
                .withId(resultSet.getInt("question_id"))
                .withBody(resultSet.getString("question"))
                .withAnswer(resultSet.getString("answer"))
                .withHelp(resultSet.getString("help"))
                .withSecond_answer(resultSet.getString("second_variant_answer"))
                .withThird_answer(resultSet.getString("third_variant_answer"))
                .build();
    }
}
