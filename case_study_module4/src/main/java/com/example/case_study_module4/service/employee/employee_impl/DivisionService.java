package com.example.case_study_module4.service.employee.employee_impl;

import com.example.case_study_module4.model.employee.Division;
import com.example.case_study_module4.repository.employee.IDivisionRepository;
import com.example.case_study_module4.service.employee.IDivisionService;
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
