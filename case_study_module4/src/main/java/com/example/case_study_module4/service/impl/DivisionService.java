package com.example.case_study_module4.service.impl;

import com.example.case_study_module4.model.Division;
import com.example.case_study_module4.repository.IDivisionRepository;
import com.example.case_study_module4.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
