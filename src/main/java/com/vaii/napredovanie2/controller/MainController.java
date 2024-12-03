package com.vaii.napredovanie2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/about")
    public String zbierka() {
        return "about";
    }
    @RequestMapping("/index")
    public String kontakt() {
        return "index";
    }
    @RequestMapping("/odborky")
    public String dokumenty() {
        return "odborky";
    }


}
