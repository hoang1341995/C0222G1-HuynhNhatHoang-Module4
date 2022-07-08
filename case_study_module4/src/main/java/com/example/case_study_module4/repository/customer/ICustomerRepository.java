package com.example.case_study_module4.repository.customer;

import com.example.case_study_module4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customer WHERE customer_name LIKE :key", nativeQuery = true)
    Page<Customer> searchByName(@Param("key") String key, Pageable pageable);

}
