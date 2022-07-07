package com.example.case_study_module4.repository.employee;

import com.example.case_study_module4.model.employee.Position;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IPositionRepository  extends PagingAndSortingRepository<Position, Integer> {

    List<Position> findAll();
}
