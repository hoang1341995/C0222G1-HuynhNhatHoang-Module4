package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.customer.Customer;
import com.example.case_study_module4.model.customer.CustomerType;
import com.example.case_study_module4.model.employee.Employee;
import com.example.case_study_module4.model.service.ServiceType;
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

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(page, 100, sort));
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

    @GetMapping(value = "/delete/{idDeleteCustomer}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer idDeleteCustomer) {
        iCustomerService.remove(idDeleteCustomer);
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

    //API for case study angular

    @GetMapping(value = "/customerList")
    public ResponseEntity<?> customerList() {
        List<Customer> list = iCustomerService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/findCustomer/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Integer id) {
        Customer customer = iCustomerService.findCustomerById(id);
        if (customer!= null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/customerTypeList")
    public ResponseEntity<?> customerTypeList() {
        List<CustomerType> list = iCustomerTypeService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/addNewCustomer")
    public ResponseEntity<?> createCustomerAPI(@RequestBody Customer customer) {
        iCustomerService.save(customer);
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/saveCustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        iCustomerService.save(customer);
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping(value = "/removeCustomer")
    public ResponseEntity<?> removeCustomer(@RequestBody Customer customer) {
        iCustomerService.remove(customer.getId());
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
