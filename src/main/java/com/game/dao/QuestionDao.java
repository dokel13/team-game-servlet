package com.game.dao;

import com.game.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> findRandom(Integer amount);
}
