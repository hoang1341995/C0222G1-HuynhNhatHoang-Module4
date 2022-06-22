package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> searchByName(String title,Pageable pageable);

}
