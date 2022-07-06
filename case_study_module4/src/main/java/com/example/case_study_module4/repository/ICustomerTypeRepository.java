package com.example.case_study_module4.repository;

import com.example.case_study_module4.model.customer.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICustomerTypeRepository  extends PagingAndSortingRepository<CustomerType, Integer> {

    List<CustomerType> findAll();
}
