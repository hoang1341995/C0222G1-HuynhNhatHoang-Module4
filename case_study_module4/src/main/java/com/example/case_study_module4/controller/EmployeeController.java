package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.employee.Employee;
import com.example.case_study_module4.model.employee.User;
import com.example.case_study_module4.service.employee.*;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IEducationService iEducationService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IUserService iUserService;


    @GetMapping(value = "")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Employee> list = iEmployeeService.findAll(PageRequest.of(page, 100, sort));
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationList", iEducationService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("employeeList", list);
        return "employee/index-employee";
    }

    @PostMapping(value = "/create/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        iUserService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/create/employee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        iEmployeeService.save(employee);
        Sort sort = Sort.by("id").ascending();
        Page<Employee> list = iEmployeeService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/edit")
    public ResponseEntity<?> editEmployee(@RequestBody Employee employee) {
        iEmployeeService.update(employee);
        Sort sort = Sort.by("id").ascending();
        Page<Employee> list = iEmployeeService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{idDelete}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer idDelete) {
        iEmployeeService.remove(idDelete);
        Sort sort = Sort.by("id").ascending();
        Page<Employee> list = iEmployeeService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/search/{key}")
    public ResponseEntity<?> searchEmployee(@PathVariable String key) {
        Sort sort = Sort.by("employee_name").ascending();
        Page<Employee> list = iEmployeeService.searchByName(key, PageRequest.of(0, 100, sort));
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

