package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    Map<String,String> dictionary=new HashMap<String,String>();
    public TranslateController() {
        init();
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam String txtSearch, Model model){
        String result=dictionary.get(txtSearch);
        model.addAttribute("word",txtSearch);
        if(result!=null){
            model.addAttribute("mean",result);
        }else{
            model.addAttribute("mean","Not found");
        }

        return "dictionary";
    }
    public void init(){
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

    }
}
