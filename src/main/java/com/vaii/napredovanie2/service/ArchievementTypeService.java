package com.vaii.napredovanie2.service;

import java.util.List;

public interface ArchievementTypeService {
    List<ArchievementTypeDto> getAllAchievementTypes();

    ArchievementTypeDto getAchievementTypesById(Long id);

}
