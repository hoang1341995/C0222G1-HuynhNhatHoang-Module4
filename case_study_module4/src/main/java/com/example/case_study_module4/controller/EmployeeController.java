package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.Employee;
import com.example.case_study_module4.model.User;
import com.example.case_study_module4.service.*;
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
        Page<Employee> list = iEmployeeService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("employeeList", list);
        return "employee/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationList", iEducationService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("userList", iUserService.findAll());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@Valid Employee employee, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
//        User user = new User();
//        user.setUsername(employee.get);
        iEmployeeService.save(employee);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/employee";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("employeeFindById", iEmployeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Employee employee, RedirectAttributes redirect) {
        iEmployeeService.update(employee);
        redirect.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "idDelete") Integer id, RedirectAttributes redirect) {
        iEmployeeService.remove(id);
        redirect.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/employee";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam(name = "key") String name,@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("employee_name").ascending();
        Page<Employee> list = iEmployeeService.searchByName(name, PageRequest.of(page, 2, sort));
        model.addAttribute("employeeList", list);
        return "employee/list";
    }
}

