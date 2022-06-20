package example.controller;

import example.model.Product;
import example.repository.BaseRepository;
import example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityTransaction;


@Controller
public class GreetingController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/")
    public String showIndex(Model model) {
        model.addAttribute("productList", iProductService.findAll());
        return "index";
    }

    @GetMapping(value = "/{id}/edit")
    public String editProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("productFindById", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirect) {
        iProductService.update(product);
        redirect.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/view")
    public String viewProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

    @GetMapping("create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirect) {
        iProductService.save(product);
        redirect.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product);
        redirect.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(String name, Model model) {
        model.addAttribute("productList", iProductService.searchByName(name));
        return "index";
    }

}
