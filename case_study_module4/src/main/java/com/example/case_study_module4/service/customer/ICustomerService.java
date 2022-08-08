package com.example.case_study_module4.service.customer;

import com.example.case_study_module4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void save(Customer customer);

    Customer findCustomerById(Integer id);

    void update(Customer customer);

    void remove(Integer id);

    Page<Customer> searchByName(String key,Pageable pageable);

}
