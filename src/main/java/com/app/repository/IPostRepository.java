package com.app.repository;

import com.app.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends PagingAndSortingRepository<Post,Long> {
    Page<Post> findAllByTitleContaining(String title, Pageable pageable);
    Page<Post> findAllByCategory_NameContaining(String categoryName,Pageable pageable);
    Iterable<Post> findAllByCategory_NameContaining(String categoryName);
}
