package com.example.exam_module4.controller.RestController;

import com.example.exam_module4.model.Customer;
import com.example.exam_module4.service.ICustomerService;
import com.example.exam_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody Customer customer) {
        iCustomerService.save(customer);
        Sort sort = Sort.by("id").ascending();
        customer.setCustomerType(iCustomerTypeService.findById(customer.getCustomerType().getId()));
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 5, sort));
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @PostMapping(value = "/edit")
    public ResponseEntity<?> edit(@Valid @RequestBody Customer customer) {
        iCustomerService.save(customer);
        Sort sort = Sort.by("id").ascending();
        customer.setCustomerType(iCustomerTypeService.findById(customer.getCustomerType().getId()));
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 5, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        iCustomerService.remove(idDelete);
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.findAll(PageRequest.of(0, 5, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/search/{key}")
    public ResponseEntity<?> search(@PathVariable String key) {
        Sort sort = Sort.by("id").ascending();
        Page<Customer> list = iCustomerService.searchByName(key, PageRequest.of(0, 5, sort));
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String, String> SQLIntegrityConstraintViolationException(
            SQLIntegrityConstraintViolationException ex) {
        System.out.println(ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("code","Mã khách hàng đã tồn tại");
        return errors;
    }
}
