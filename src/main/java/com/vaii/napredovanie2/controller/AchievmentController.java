//package com.vaii.napredovanie2.controller;
//
//import com.vaii.napredovanie2.entity.Achievement;
//import com.vaii.napredovanie2.repository.AchievementRepository;
//import com.vaii.napredovanie2.service.ArchievementDto;
//import com.vaii.napredovanie2.service.ArchievementService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class AchievmentController {
//
//    @Autowired
//    private AchievementRepository achievementRepository;
//
//    @Autowired
//    private ArchievementService archievementService;
//
//    @GetMapping("/achievements")
//    public String getAllAchievements(Model model) {
//        // Fetch all achievements from the database
//        List<Achievement> achievements = achievementRepository.findAll();
//
//        // Add achievements to the model to be displayed on the page
//        model.addAttribute("achievements", achievements);
//
//        return "achievements";  // Return the view name, e.g., "achievements.html"
//    }
//
//    @GetMapping("/odborky")
//    public String getAchievementsOdborka(Model model) {
//        // Fetch achievements of type "Odborka"
//        List<ArchievementDto> achievements = archievementService.getAchievementsByType("Odborka");
//
//        model.addAttribute("achievements", achievements);
//        model.addAttribute("selectedType", "Odborka");  // Display the selected type in the view
//        return "achievements";  // Return the name of the HTML page (achievements.html)
//    }
//}