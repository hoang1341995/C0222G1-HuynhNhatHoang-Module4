package com.example.case_study_module4.service.impl.service_impl;

import com.example.case_study_module4.model.service.RentType;
import com.example.case_study_module4.repository.service.IRentTypeRepository;
import com.example.case_study_module4.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
