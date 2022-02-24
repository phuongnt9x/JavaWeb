package com.app.controller;

import com.app.model.Post;
import com.app.service.ICategoryService;
import com.app.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
public class RestPostController {
    @Autowired
    private IPostService postService;
    @GetMapping
    public ResponseEntity<Iterable<Post>> getAllPosts(){
        List<Post> posts = (List<Post>) postService.findAll();
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("categories/{categoryName}")
    public ResponseEntity<Iterable<Post>> getAllPostsByCategoryName(@PathVariable String categoryName){
        List<Post> posts = (List<Post>) postService.findAllByCategory_NameContaining(categoryName);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable Long id){
        Optional<Post> post = postService.findById(id);
        if (post.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
