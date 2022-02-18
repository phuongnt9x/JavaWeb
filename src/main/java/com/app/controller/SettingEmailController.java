package com.app.controller;

import com.app.model.SettingEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/setting")
public class SettingEmailController {

    SettingEmail settingEmail = new SettingEmail("Vietnamese", 25, false, "Thor");

    @GetMapping("")
    public ModelAndView showInfo() {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("settingEmail", settingEmail);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("edit","settingEmail", this.settingEmail);
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pageSize = {5, 10, 15, 25, 50, 100};
        modelAndView.addObject("pageSizes", pageSize);
        modelAndView.addObject("languages", languages);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String save(@ModelAttribute("settingEmail") SettingEmail settingEmail) {
        ModelAndView modelAndView = new ModelAndView();
        this.settingEmail = settingEmail;
        modelAndView.addObject("settingEmail", settingEmail);
        return "info";
    }
}
