package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.customer.Customer;
import com.example.case_study_module4.model.employee.Employee;
import com.example.case_study_module4.service.customer.ICustomerService;
import com.example.case_study_module4.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "customer/index-customer";
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        iCustomerService.save(customer);
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/edit")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        iCustomerService.update(customer);
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{idDelete}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer idDelete) {
        iCustomerService.remove(idDelete);
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/search/{key}")
    public ResponseEntity<?> searchCustomer(@PathVariable String key) {
        Sort sort = Sort.by("customer_name").ascending();
        Page<Customer> list = iCustomerService.searchByName(key, PageRequest.of(0, 100, sort));
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
