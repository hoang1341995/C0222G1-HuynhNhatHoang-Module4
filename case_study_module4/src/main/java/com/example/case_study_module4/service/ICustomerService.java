package com.example.case_study_module4.service;

import com.example.case_study_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Optional<Customer> findById(int id);

    void update(Customer customer);

    void remove(Integer id);

    Page<Customer> searchByName(String key,Pageable pageable);

}
