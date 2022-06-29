package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("json")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/category")
    public Page<Category> returnCategory(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("id").ascending();
        Page<Category> list = iCategoryService.findAll(PageRequest.of(page, 10, sort));
        return list;
    }
    @GetMapping(value = "/view")
    public Page<Blog> returnPostById(@RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "post", defaultValue = "0") Integer id) {
        Sort sort = Sort.by("id").ascending();
        Page<Blog> list = iBlogService.findPostById(id,PageRequest.of(page, 2, sort));
        return list;
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<?> returnPosts(@RequestParam(name = "category", defaultValue = "") String categorys) {
        Set<Blog> blogset;
        blogset = iCategoryService.findByName(categorys).getBlogs();
        return new ResponseEntity<>(blogset, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> returnPostAll() {
        List<Blog> list = iBlogService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
