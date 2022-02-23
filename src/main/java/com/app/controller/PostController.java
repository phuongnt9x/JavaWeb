package com.app.controller;

import com.app.model.Category;
import com.app.model.Post;
import com.app.service.IPostService;
import com.app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private IPostService postService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping
    public ModelAndView showListBlog(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Post> posts;
        if(search.isPresent()){
            posts = postService.findAllByTitleContaining(search.get(), pageable);
        } else {
            posts = postService.findAll(pageable);
        }
        ModelAndView modelAndView=new ModelAndView("/blog/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
    @GetMapping("/create-post")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView saveBlog(@ModelAttribute("post") Post post) {
        post.setDate(new Date());
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    /**
     *
     */
    @GetMapping("/edit-post/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("post", post.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-post")
    public ModelAndView updateblog(@ModelAttribute("post") Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "blog updated successfully");
        return modelAndView;
    }

    /**
     *
     */
    @GetMapping("/delete-post/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("post", post.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
    @GetMapping("/detail-post/{id}")
    public ModelAndView showDetailBlog(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("post", post.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-post")
    public String deletePost(@ModelAttribute("post") Post post) {
        postService.remove(post.getId());
        return "redirect:/";
    }


}
