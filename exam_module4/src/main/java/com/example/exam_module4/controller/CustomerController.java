package com.example.exam_module4.controller;

import com.example.exam_module4.model.Customer;
import com.example.exam_module4.model.CustomerType;
import com.example.exam_module4.service.ICustomerService;
import com.example.exam_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Customer> customerList = iCustomerService.findAll(PageRequest.of(page, 5, sort));
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerList",customerList);
        model.addAttribute("customerTypeList",customerTypeList);
        return "index";
    }



}
