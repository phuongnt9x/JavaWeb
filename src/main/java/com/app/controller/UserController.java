package com.app.controller;

import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.app.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","user",new User());
    }
    @PostMapping("")
    public ModelAndView create(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("create","user",user);

        }   else {
            return new ModelAndView("create","user",new User());
        }
    }
}
