package com.example.case_study_module4.repository.service;

import com.example.case_study_module4.model.service.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IServiceTypeRepository extends PagingAndSortingRepository<ServiceType, String> {

    List<ServiceType> findAll();
}
