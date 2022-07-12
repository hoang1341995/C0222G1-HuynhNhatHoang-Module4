package com.example.exam_module4.service;

import com.example.exam_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(Integer id);

    Page<Customer> searchByName(String name,Pageable pageable);

}
