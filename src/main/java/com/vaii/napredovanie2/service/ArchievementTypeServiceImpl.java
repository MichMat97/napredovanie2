package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.AchievementType;
import com.vaii.napredovanie2.repository.AchievementTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArchievementTypeServiceImpl implements ArchievementTypeService {


    @Autowired
    private AchievementTypeRepository achievmentTypeRepository;

    public ArchievementTypeServiceImpl(AchievementTypeRepository achievementTypeRepository) {
        this.achievmentTypeRepository = achievementTypeRepository;
    }

    @Override
    public List<ArchievementTypeDto> getAllAchievementTypes() {
        return achievmentTypeRepository.findAll().stream()
                .map(achievementType -> new ArchievementTypeDto(
                        achievementType.getId(),
                        achievementType.getName()))
                .collect(Collectors.toList());
    }

    public ArchievementTypeDto getAchievementTypesById(Long id) {
        AchievementType achievementType = achievmentTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Nenájdený typ napredovania s id: " + id));

        return new ArchievementTypeDto(
                achievementType.getId(),
                achievementType.getName()
        );
    }

}