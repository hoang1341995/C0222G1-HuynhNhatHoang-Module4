package com.example.case_study_module4.service;

import com.example.case_study_module4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Optional<Employee> findById(int id);

    void update(Employee employee);

    void remove(Integer id);

    Page<Employee> searchByName(String key,Pageable pageable);
}
