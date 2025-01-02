package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.AchievementType;
import com.vaii.napredovanie2.entity.CardClass;

import com.vaii.napredovanie2.entity.Achievement;
import com.vaii.napredovanie2.repository.AchievementRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArchievementServiceImpl implements ArchievementService {

    private AchievementRepository achievmentRepository;

    public ArchievementServiceImpl(AchievementRepository achievmentRepository) {
        this.achievmentRepository = achievmentRepository;

    }

    @Override
    public List<ArchievementDto> getAllAchievements() {
        return achievmentRepository.findAllByOrderByNameAsc().stream()
                .map(achievement -> new ArchievementDto(
                        achievement.getId(),
                        achievement.getName(),
                        achievement.getType(),  // Assuming type is an AchievementType object
                        achievement.getDescription(),
                        achievement.getImgPath(),
                        achievement.getCardClass()))
                .collect(Collectors.toList());
    }

    public List<ArchievementDto> getAchievementsByType(String type) {
        return achievmentRepository.findByType(type).stream()
                .map(achievement -> new ArchievementDto(
                        achievement.getId(),
                        achievement.getName(),
                        achievement.getType(),  // Assuming type is an AchievementType object
                        achievement.getDescription(),
                        achievement.getImgPath(),
                        achievement.getCardClass()))
                .collect(Collectors.toList());
    }

    public ArchievementDto getAchievementsById(Long id) {
        Achievement achievement = achievmentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Napredovanie nenájdené"));

        return new ArchievementDto(
                achievement.getId(),
                achievement.getName(),
                achievement.getType(), // Získavame názov typu AchievementType
                achievement.getDescription(),
                achievement.getImgPath(),
                achievement.getCardClass()
        );
    }

    public ArchievementDto getAchievementsByName(String name) {
        Achievement achievement = achievmentRepository.findByName(name);

        return new ArchievementDto(
                achievement.getId(),
                achievement.getName(),
                achievement.getType(), // Získavame názov typu AchievementType
                achievement.getDescription(),
                achievement.getImgPath(),
                achievement.getCardClass()
        );
    }

    public void saveAchievement(Achievement achievement) {
        achievmentRepository.save(achievement);
    }

    @Transactional
    @Override
    public void deleteAchievement(Long id) {
        ArchievementDto existingAchievement = getAchievementsById(id);
        achievmentRepository.deleteAchievementById(existingAchievement.getId());

    }

    @Transactional
    @Override
    public void updateAchievement(Long id, String name, AchievementType type, String description, String imgPath, CardClass cardClass) {
        Achievement existingAchievement = achievmentRepository.findById(id).
                orElseThrow( () -> new RuntimeException("Napredovanie s dan7m ID nen8jden0"));
        if (existingAchievement != null) {
            achievmentRepository.updateAchievement(id, name, type, description, imgPath, cardClass);
        } else {
            throw new EntityNotFoundException("Nenájdené napredovanie s názvom: " + name);
        }
    }
}