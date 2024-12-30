package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.Achievement;
import com.vaii.napredovanie2.repository.AchievementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArchievementServiceImpl implements ArchievementService {


    @Autowired
    private AchievementRepository achievmentRepository;

    @Override
    public List<ArchievementDto> getAllAchievements() {
        return achievmentRepository.findAll().stream()
                .map(achievement -> new ArchievementDto(
                        achievement.getId(),
                        achievement.getName(),
                        achievement.getType(),  // Assuming type is an AchievementType object
                        achievement.getDescription(),
                        achievement.getImgPath()))
                .collect(Collectors.toList());
    }

    public List<ArchievementDto> getAchievementsByType(String type) {
        return achievmentRepository.findByType(type).stream()
                .map(achievement -> new ArchievementDto(
                        achievement.getId(),
                        achievement.getName(),
                        achievement.getType(),  // Assuming type is an AchievementType object
                        achievement.getDescription(),
                        achievement.getImgPath()))
                .collect(Collectors.toList());
    }

}