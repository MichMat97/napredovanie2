package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.Achievement;
import com.vaii.napredovanie2.entity.AchievementType;
import com.vaii.napredovanie2.entity.CardClass;

import java.util.List;

public interface ArchievementService {
    List<ArchievementDto> getAllAchievements();

    List<ArchievementDto> getAchievementsByType(String type);

    ArchievementDto getAchievementsById(Long id);

    ArchievementDto getAchievementsByName(String name);

    void saveAchievement(Achievement achievement);

    void deleteAchievement(Long id);

    void updateAchievement(Long id, String name, AchievementType type, String description, String imgPath, CardClass cardClass);



}
