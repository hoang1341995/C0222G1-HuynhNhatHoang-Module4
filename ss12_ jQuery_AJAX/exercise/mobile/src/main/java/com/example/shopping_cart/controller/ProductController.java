package com.example.shopping_cart.controller;


import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String showShop(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "index";
    }

    @PostMapping("/addCart")
    public String addToCart(@SessionAttribute Cart cart, @RequestParam("idCart") Long id, RedirectAttributes redirect) {
        Optional<Product> productOptional = productService.findById(id);

        cart.addProduct(productOptional.get());
        redirect.addFlashAttribute("mess", "Thêm vào giỏ thành công");
        redirect.addFlashAttribute("messModal", "$(`#messModal`).modal()");
        return "redirect:/";
    }

    @PostMapping("/pay")
    public String addToCart(@SessionAttribute("cart") Cart cart, RedirectAttributes redirect) {
        cart.getProducts().clear();
        redirect.addFlashAttribute("mess", "Thanh toán thành công");
        redirect.addFlashAttribute("messModal", "$(`#messModal`).modal()");
        return "redirect:/";
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}/{value}")
    public String changeNumber(@SessionAttribute("cart") Cart cart, @PathVariable("id") Long id, @PathVariable("value") Integer value, RedirectAttributes redirect) {
        Optional<Product> productOptional = productService.findById(id);
        if (value == 1){
            cart.addProduct(productOptional.get());
        }else{
            cart.reduceProduct(productOptional.get());
        }
        redirect.addFlashAttribute("messModal", "$(`#shoppingCart`).modal()");
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteProduct(@SessionAttribute("cart") Cart cart, @PathVariable("id") Long id, RedirectAttributes redirect) {
        Optional<Product> productOptional = productService.findById(id);
        cart.deleteProduct(productOptional.get());
        redirect.addFlashAttribute("messModal", "$(`#shoppingCart`).modal()");
        return "redirect:/";
    }
}
