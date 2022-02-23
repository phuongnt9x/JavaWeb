package com.app.service;

import com.app.model.Blog;
import com.app.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog customer) {
        blogRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
