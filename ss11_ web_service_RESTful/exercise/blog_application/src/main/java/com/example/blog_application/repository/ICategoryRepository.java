package com.example.blog_application.repository;


import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {

    @Query(value = "select * from category",nativeQuery = true)
    List<Category> findAll();

    @Query(value = "select * from category",nativeQuery = true)
    Page<Category> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM category WHERE name = :name", nativeQuery = true)
    Integer searchIdByName(@Param("name") String name);

}
