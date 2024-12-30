package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.Achievement;

import java.util.List;

public interface ArchievementService {
    List<ArchievementDto> getAllAchievements();

    List<ArchievementDto> getAchievementsByType(String type);

    ArchievementDto getAchievementsById(Long id);

}
