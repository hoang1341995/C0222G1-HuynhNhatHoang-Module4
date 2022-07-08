package com.example.case_study_module4.repository.service;

import com.example.case_study_module4.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, String> {

    List<ServiceType> findAll();
}
