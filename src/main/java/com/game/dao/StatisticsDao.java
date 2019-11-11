package com.game.dao;

import com.game.domain.Statistics;

import java.util.List;
import java.util.Optional;

public interface StatisticsDao {

    Optional<List<Statistics>> findPaginatedStatistics(Integer page, Integer pageSize);
}
