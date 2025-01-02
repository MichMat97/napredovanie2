package com.vaii.napredovanie2.controller;

import com.vaii.napredovanie2.service.ArchievementDto;
import com.vaii.napredovanie2.service.ArchievementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class MainController {

    private ArchievementService archievementService;

    public MainController(ArchievementService archievementService) {
        this.archievementService = archievementService;
    }

    @RequestMapping("/about")
    public String ostranke() {
        return "about";
    }

    @RequestMapping("/index")
    public String domov() {
        return "index";
    }

    @RequestMapping("/odborky")
    public String odborky(Model model) {
        List<ArchievementDto> odborky = archievementService.getAllAchievements();
        model.addAttribute("odborky", odborky);
        return "odborky";
    }

}
