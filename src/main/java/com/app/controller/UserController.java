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
    private IUserService userService;
    @GetMapping("")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","user",new User());
    }
    @PostMapping("")
    public ModelAndView create(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("create","user",user);

        }   else {
            ModelAndView modelAndView=new ModelAndView("result","user",user);
            userService.save(user);
            return modelAndView;
        }
    }
}
