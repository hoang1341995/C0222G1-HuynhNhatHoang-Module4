package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    Page<Blog> findPostByCategory(String category,Pageable pageable);

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> searchByName(String title,Pageable pageable);

    List<Blog> ajaxSearchByName(String title);

    Page<Blog> findPostById(Integer id, Pageable pageable);



}
