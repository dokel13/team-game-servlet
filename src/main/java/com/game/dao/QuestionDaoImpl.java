package com.game.dao;

import com.game.dao.mapper.Mapper;
import com.game.dao.mapper.QuestionMapper;
import com.game.domain.Question;
import com.game.exception.DatabaseRuntimeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QuestionDaoImpl extends AbstractDao<Question> implements QuestionDao {

    @Override
    protected Mapper<Question> getMapper() {
        return new QuestionMapper();
    }

    @Override
    public List<Question> findRandom(Integer amount) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(getSql("select.random.questions"))) {
            statement.setInt(1, amount);
            ResultSet resultSet = statement.executeQuery();

            return constructMultivaluedResult(resultSet);
        } catch (SQLException e) {
            throw new DatabaseRuntimeException(e, "Finding questions operation exception!");
        }
    }
}
