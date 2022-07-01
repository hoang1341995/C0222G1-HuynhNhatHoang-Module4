package com.example.case_study_module4.repository;

import com.example.case_study_module4.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IPositionRepository  extends PagingAndSortingRepository<Position, Integer> {

    List<Position> findAll();
}
