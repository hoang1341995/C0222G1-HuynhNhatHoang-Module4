package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "/")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
       Sort sort = Sort.by("id").ascending();
        Page<Blog> list = iBlogService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("blogList",list);
        return "index";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
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
    public String searchByName(String name, Model model) {
        model.addAttribute("blogList", iBlogService.searchByName(name));
        return "index";
    }

}
