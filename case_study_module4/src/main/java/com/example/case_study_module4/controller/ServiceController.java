package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.employee.Employee;
import com.example.case_study_module4.model.employee.User;
import com.example.case_study_module4.model.service.Service;
import com.example.case_study_module4.service.service.IRentTypeService;
import com.example.case_study_module4.service.service.IServiceService;
import com.example.case_study_module4.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService iServiceService;

    @Autowired
    private IServiceTypeService iServiceTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping(value = "")
    public String showIndex(@PageableDefault(value = 10) Pageable pageable, Model model) {
//        Sort sort = Sort.by("id").ascending();
//        Page<Service> list = iServiceService.findAll(PageRequest.of(page, 100, sort));
        Page<Service> list = iServiceService.findAll(pageable);
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("serviceTypeList", iServiceTypeService.findAll());
        model.addAttribute("serviceList", list);
        return "service/index-service";
    }


    @PostMapping(value = "/create")
    public ResponseEntity<?> createService(@PageableDefault(value = 10) Pageable pageable,@RequestBody Service service) {
        iServiceService.save(service);
        Sort sort = Sort.by("id").ascending();
        System.out.println(iServiceService.findAll());
        Page<Service> list = iServiceService.findAll(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
//
//    @PostMapping(value = "/edit")
//    public ResponseEntity<?> editEmployee(@RequestBody Employee employee) {
//        iEmployeeService.update(employee);
//        Sort sort = Sort.by("id").ascending();
//        Page<Employee> list = iEmployeeService.findAll(PageRequest.of(0, 100, sort));
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/delete/{idDelete}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable Integer idDelete) {
//        iEmployeeService.remove(idDelete);
//        Sort sort = Sort.by("id").ascending();
//        Page<Employee> list = iEmployeeService.findAll(PageRequest.of(0, 100, sort));
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/search/{key}")
//    public ResponseEntity<?> searchEmployee(@PathVariable String key) {
//        Sort sort = Sort.by("employee_name").ascending();
//        Page<Employee> list = iEmployeeService.searchByName(key, PageRequest.of(0, 100, sort));
//        if (!list.isEmpty()){
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

}
