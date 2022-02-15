package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String greeting(@RequestParam String usd,@RequestParam String rate, Model model) {
        Float usdf=Float.parseFloat(usd);
        Float ratef=Float.parseFloat(rate);
        Float vnd=usdf*ratef;
        model.addAttribute("usd", usdf);
        model.addAttribute("vnd", vnd);
        model.addAttribute("rate", ratef);
        return "convert";
    }
    @GetMapping("/")
    public  String index(){
        return "index";
    }
}
