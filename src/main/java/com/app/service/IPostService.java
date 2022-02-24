package com.app.service;

import com.app.model.Category;
import com.app.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService extends IGeneralService<Post> {
    Page<Post> findAll(Pageable pageable);
    Page<Post> findAllByTitleContaining(String title,Pageable pageable);
    Page<Post> findAllByCategory_NameContaining(String categoryName,Pageable pageable);
}
