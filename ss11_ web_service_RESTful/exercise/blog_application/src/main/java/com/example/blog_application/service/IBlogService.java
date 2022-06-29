package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findPostByCategory(String category,Pageable pageable);

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> searchByName(String title,Pageable pageable);

    Page<Blog> findPostById(Integer id, Pageable pageable);



}
