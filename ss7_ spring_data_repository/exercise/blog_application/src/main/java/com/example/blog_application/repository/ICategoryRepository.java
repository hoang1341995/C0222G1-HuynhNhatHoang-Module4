package com.example.blog_application.repository;


import com.example.blog_application.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    @Query(value = "select * from category",nativeQuery = true)
    List<Category> findAll();
}
