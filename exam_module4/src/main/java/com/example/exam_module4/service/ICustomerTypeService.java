package com.example.exam_module4.service;

import com.example.exam_module4.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();

    CustomerType findById(int id);

}
