package com.example.exam_module4.service.impl;

import com.example.exam_module4.model.CustomerType;
import com.example.exam_module4.repository.ICustomerTypeRepository;
import com.example.exam_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return iCustomerTypeRepository.findById(id);
    }
}
