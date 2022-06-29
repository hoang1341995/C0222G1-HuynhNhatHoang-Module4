package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        Page<Category> list = iCategoryService.findAll(PageRequest.of(page, 2, sort));
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
    public Page<Blog> returnPosts(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "category", defaultValue = "") String categorys) {
        Sort sort = Sort.by("posting_date").ascending();
        Page<Blog> list;
        if (!categorys.equals("")){
            list = iBlogService.findPostByCategory(categorys, PageRequest.of(page, 2, sort));

        }else{
            list = iBlogService.findAll(PageRequest.of(page, 2, sort));
        }
        return list;
    }




}
