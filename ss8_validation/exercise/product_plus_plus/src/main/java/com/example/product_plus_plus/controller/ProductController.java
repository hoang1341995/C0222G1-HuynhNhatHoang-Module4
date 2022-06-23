package com.example.product_plus_plus.controller;

import com.example.product_plus_plus.model.Product;
import com.example.product_plus_plus.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Product> list = iProductService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("productList",list);
        return "index";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()){
            return "create";
        }
        iProductService.save(product);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("productFindById", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirect) {
        iProductService.update(product);
        redirect.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/view")
    public String viewProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

    @GetMapping("{id}/delete")
    public String deleteProduct(@PathVariable Integer id, RedirectAttributes redirect) {
        iProductService.remove(id);
        redirect.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page,String name, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Product> blogList = iProductService.searchByName(name,PageRequest.of(page, 2, sort));
        model.addAttribute("productList", blogList);
        return "index";
    }

}
