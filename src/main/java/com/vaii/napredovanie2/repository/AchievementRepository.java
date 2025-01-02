package com.vaii.napredovanie2.repository;

import com.vaii.napredovanie2.entity.Achievement;
import com.vaii.napredovanie2.entity.AchievementType;
import com.vaii.napredovanie2.entity.CardClass;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    @Query("SELECT a FROM Achievement a WHERE a.type.name = :typeName")
    List<Achievement> findByType(@Param("typeName") String typeName);

    @Modifying
    @Transactional
    @Query("delete from Achievement a where a.id = :id")
    void deleteAchievementById(@Param("id") Long id);

    Achievement findByName(String name);

    @Modifying
    @Transactional
    @Query("update Achievement a set a.name = :name, a.type = :type, a.description = :description, a.imgPath = :imgPath, a.cardClass = :cardClass where a.id = :id")
    void updateAchievement(@Param("id") Long id, @Param("name") String name, @Param("type") AchievementType type, @Param("description") String description, @Param("imgPath") String imgPath, @Param("cardClass") CardClass cardClass);

    List<Achievement> findAllByOrderByNameAsc();
}