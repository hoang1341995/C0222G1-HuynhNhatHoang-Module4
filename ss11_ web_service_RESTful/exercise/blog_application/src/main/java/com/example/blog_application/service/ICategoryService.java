package com.example.blog_application.service;

import com.example.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);
}
