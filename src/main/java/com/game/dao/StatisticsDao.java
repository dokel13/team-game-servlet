package com.game.dao;

import com.game.domain.Statistics;

import java.util.List;

public interface StatisticsDao {

    List<Statistics> findPaginated(Integer page, Integer pageSize);
}
