package com.vaii.napredovanie2.service;

import java.util.List;

public interface ArchievementService {
    List<ArchievementDto> getAllAchievements();

    List<ArchievementDto> getAchievementsByType(String type);

}
