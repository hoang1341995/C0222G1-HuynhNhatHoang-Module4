package com.example.case_study_module4.repository;

import com.example.case_study_module4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee WHERE employee_name LIKE :key", nativeQuery = true)
    Page<Employee> searchByName(@Param("key") String key, Pageable pageable);

}
