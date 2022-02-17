package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class SandwichController {

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
            if(condiment.length==0){
                condiment[0]="Not condiment";
            }
           String resultString="";
            for(String s:condiment){
                resultString+=s+"<br>";
            }
            model.addAttribute("condiment",resultString);
           return "result";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

}