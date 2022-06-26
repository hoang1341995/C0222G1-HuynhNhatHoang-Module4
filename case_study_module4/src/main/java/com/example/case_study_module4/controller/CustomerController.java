package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.Customer;
import com.example.case_study_module4.service.ICustomerService;
import com.example.case_study_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("customerList", list);
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Valid Customer customer, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        iCustomerService.save(customer);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/customer";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customerFindById", iCustomerService.findById(id));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Customer customer, RedirectAttributes redirect) {
        iCustomerService.update(customer);
        redirect.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "idDelete") Integer id, RedirectAttributes redirect) {
        iCustomerService.remove(id);
        redirect.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/customer";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam(name = "key") String name,@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("customer_name").ascending();
        Page<Customer> list = iCustomerService.searchByName(name, PageRequest.of(page, 2, sort));
        model.addAttribute("customerList", list);
        return "customer/list";
    }
}
