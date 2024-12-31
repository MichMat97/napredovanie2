package com.vaii.napredovanie2.controller;

import com.vaii.napredovanie2.service.ArchievementDto;
import com.vaii.napredovanie2.service.ArchievementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/odborka")
public class AchievementController {

    private ArchievementService achievementService;

    public AchievementController(ArchievementService archievementService) {
        this.achievementService = archievementService;
    }

    @GetMapping("/{id}")
    public String getAchievementDetails(@PathVariable Long id, Model model) {
        ArchievementDto achievement = achievementService.getAchievementsById(id); // Načítanie záznamu
        model.addAttribute("achievement", achievement);
        return "napredovanie-details";
    }
}