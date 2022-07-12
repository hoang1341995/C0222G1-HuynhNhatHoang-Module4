package com.example.exam_module4.repository;

import com.example.exam_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer_table",nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM customer_table WHERE id = :id", nativeQuery = true)
    Customer findById(@Param("id") int id);


    @Query(value = "SELECT * FROM customer_table WHERE name LIKE :name", nativeQuery = true)
    Page<Customer> searchByName(@Param("name") String name,Pageable pageable);


}
