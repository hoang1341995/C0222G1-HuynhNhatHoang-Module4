package com.example.exam_module4.repository;


import com.example.exam_module4.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerTypeRepository  extends JpaRepository<CustomerType, Integer> {

    @Query(value = "SELECT * FROM customer_type WHERE id = :id", nativeQuery = true)
    CustomerType findById(@Param("id") int id);

}
