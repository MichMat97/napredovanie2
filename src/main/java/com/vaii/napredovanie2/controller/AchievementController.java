package com.vaii.napredovanie2.controller;

import com.vaii.napredovanie2.entity.Achievement;
import com.vaii.napredovanie2.service.ArchievementDto;
import com.vaii.napredovanie2.service.ArchievementService;
import com.vaii.napredovanie2.service.ArchievementTypeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/odborka")
public class AchievementController {

    private ArchievementService achievementService;
    private ArchievementTypeService archievementTypeService;

    public AchievementController(ArchievementService archievementService, ArchievementTypeService archievementTypeService) {
        this.achievementService = archievementService;
        this.archievementTypeService = archievementTypeService;
    }

    @GetMapping("/{id}")
    public String getAchievementDetails(@PathVariable Long id, Model model) {
        ArchievementDto achievement = achievementService.getAchievementsById(id); // Načítanie záznamu
        model.addAttribute("achievement", achievement);
        return "napredovanie-details";
    }

    @GetMapping("/save")
    public String showAddArchievementForm(Model model) {
        model.addAttribute("achievement", new Achievement());
        model.addAttribute("achievementTypes", archievementTypeService.getAllAchievementTypes());
        return "addAchievement";
    }

    @PostMapping("/save")
    public String addArchievement(@ModelAttribute("achievement") Achievement achievement) {
        if (achievement.getId() != null) {
            achievementService.updateAchievement(
                    achievement.getId(),
                    achievement.getName(),
                    achievement.getType(),
                    achievement.getDescription(),
                    achievement.getImgPath(),
                    achievement.getCardClass()
            );
        } else {
            achievementService.saveAchievement(achievement);
        }
        return "redirect:/odborky";
    }

    @GetMapping("/upravNapredovanie")
    public String showEditForm(@RequestParam String name, Model model) {
        ArchievementDto achievement = achievementService.getAchievementsByName(name);
        model.addAttribute("achievement", achievement);
        model.addAttribute("achievementTypes", archievementTypeService.getAllAchievementTypes());
        return "addAchievement";
    }
    @GetMapping("/zmazNapredovanie")
    public String deleteAchievement(@RequestParam String name) {
        System.out.println("Prisiel som do mazania v kontroleri");
        ArchievementDto existingAchievement = achievementService.getAchievementsByName(name);
        System.out.println(existingAchievement.getName());
        if (existingAchievement != null && existingAchievement.getName() != null && !existingAchievement.getName().isEmpty()) {
            achievementService.deleteAchievement(existingAchievement.getId());
        }
        return "redirect:/odborky";
    }
}