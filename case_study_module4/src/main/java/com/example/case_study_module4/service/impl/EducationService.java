package com.example.case_study_module4.service.impl;

import com.example.case_study_module4.model.Education;
import com.example.case_study_module4.repository.IEducationRepository;
import com.example.case_study_module4.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationService implements IEducationService {

    @Autowired
    private IEducationRepository iEducationRepository;


    @Override
    public List<Education> findAll() {
        return iEducationRepository.findAll();
    }
}
