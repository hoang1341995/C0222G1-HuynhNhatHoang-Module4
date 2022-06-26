package com.example.case_study_module4.service.impl;

import com.example.case_study_module4.model.Customer;
import com.example.case_study_module4.model.Employee;
import com.example.case_study_module4.repository.IEmployeeRepository;
import com.example.case_study_module4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> searchByName(String key, Pageable pageable) {

        return iEmployeeRepository.searchByName("%" + key + "%", pageable);
    }
}
