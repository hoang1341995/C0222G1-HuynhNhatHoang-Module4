package com.example.validate_form_register.controller;


import com.example.validate_form_register.model.Register;
import com.example.validate_form_register.service.IRegisterService;
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
public class RegisterController {

    @Autowired
    private IRegisterService iRegisterService;

    @GetMapping(value = "/list")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Register> list = iRegisterService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("registerList", list);
        return "list";
    }

    @GetMapping(value = "/")
    public String showCreate(Model model) {
        model.addAttribute("register", new Register());
        return "index";
    }

    @PostMapping("/")
    public String saveProduct(@Valid Register register, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        iRegisterService.save(register);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/list";
    }

}
