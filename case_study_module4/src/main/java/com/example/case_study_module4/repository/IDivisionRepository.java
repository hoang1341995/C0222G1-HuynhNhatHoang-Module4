package com.example.case_study_module4.repository;

import com.example.case_study_module4.model.employee.Division;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IDivisionRepository extends PagingAndSortingRepository<Division, Integer> {

    List<Division> findAll();
}
