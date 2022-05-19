package com.example.demo.repository;

import com.example.demo.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
    @Query("SELECT e.userId " +
            "FROM Exchange e " +
            "WHERE e.value >= 10000 ")
    Set<Integer> findAllByValueGreaterThanEqual();

    @Query("SELECT e.userId " +
            "FROM Exchange e " +
            "GROUP BY e.userId " +
            "HAVING sum(e.value) > 100000 ")
    Set<Integer> findAllByValue100000();

    @Query("SELECT concat(e.from,'->', e.to) " +
            "FROM Exchange e " +
            "GROUP BY e.from, e.to " +
            "ORDER BY count(e)  DESC")
    Set<String> findAllByToCount();
}
