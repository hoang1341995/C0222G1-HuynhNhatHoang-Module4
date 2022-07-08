package com.example.case_study_module4.repository.service;

import com.example.case_study_module4.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentTypeRepository  extends JpaRepository<RentType, String> {

    List<RentType> findAll();
}
