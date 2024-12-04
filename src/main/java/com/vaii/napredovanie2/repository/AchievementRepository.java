package com.vaii.napredovanie2.repository;

import com.vaii.napredovanie2.entity.Achievement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    @Query("SELECT a FROM Achievement a WHERE a.type.name = :typeName")
    List<Achievement> findByType(@Param("typeName") String typeName);
}