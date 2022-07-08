package com.example.case_study_module4.service.service.service_impl;

import com.example.case_study_module4.model.service.ServiceType;
import com.example.case_study_module4.repository.service.IServiceTypeRepository;
import com.example.case_study_module4.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
