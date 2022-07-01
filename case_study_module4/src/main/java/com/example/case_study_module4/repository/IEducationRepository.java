package com.example.case_study_module4.repository;

import com.example.case_study_module4.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IEducationRepository extends PagingAndSortingRepository<Education, Integer> {

    List<Education> findAll();
}
