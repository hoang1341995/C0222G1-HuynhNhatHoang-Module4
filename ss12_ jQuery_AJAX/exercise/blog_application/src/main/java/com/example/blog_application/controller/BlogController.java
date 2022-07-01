package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
       Sort sort = Sort.by("posting_date").ascending();
        Page<Blog> list = iBlogService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("blogList",list);
        return "index";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(Blog blog, RedirectAttributes redirect) {
        iBlogService.save(blog);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blogFindById", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String updateBlog(Blog blog, RedirectAttributes redirect) {
        iBlogService.update(blog);
        redirect.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/view")
    public String viewBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }

    @GetMapping("{id}/delete")
    public String deleteBlog(@PathVariable Integer id, RedirectAttributes redirect) {
        iBlogService.remove(id);
        redirect.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page,String name, Model model) {
        Sort sort = Sort.by("posting_date").ascending();
        Page<Blog> blogList = iBlogService.searchByName(name,PageRequest.of(page, 2, sort));
        model.addAttribute("blogList", blogList);
        return "index";
    }

    @GetMapping("/ajaxSearch/{key}")
    public ResponseEntity<?> ajaxSearch(@PathVariable String key) {
        System.out.println(key);
        List<Blog> list = iBlogService.ajaxSearchByName(key);
        if (!list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/downloadMove/{value}")
        public ResponseEntity<?> downloadMove(@PathVariable int value) {

        Sort sort = Sort.by("posting_date").ascending();
        Page<Blog> list = iBlogService.findAll(PageRequest.of(0, value, sort));

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
