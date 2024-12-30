package com.vaii.napredovanie2.repository;

import com.vaii.napredovanie2.entity.AchievementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AchievementTypeRepository extends JpaRepository<AchievementType, Long> {
    @Query("SELECT a FROM AchievementType a WHERE a.id = :id")
    AchievementType findAchievementTypeById(@Param("id") Long id);
}