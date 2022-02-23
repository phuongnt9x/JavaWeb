package com.app.controller;

import com.app.model.Category;
import com.app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping()
    public ModelAndView showListCategory(){
        Iterable<Category> categories=categoryService.findAll();
        ModelAndView modelAndView=new ModelAndView("/category/list");
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveCategory(@ModelAttribute Category category){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public ModelAndView updateCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
    @PostMapping("/delete/")
    public ModelAndView deleteCategory(@ModelAttribute Category category) {
        categoryService.remove(category.getId());
       ModelAndView modelAndView=new ModelAndView("/category/list");
       return modelAndView;
    }

}
