package com.example.case_study_module4.repository.service;

import com.example.case_study_module4.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IServiceRepository  extends JpaRepository<Service, Integer> {
    @Query(value = "SELECT * FROM service WHERE service_name LIKE :key", nativeQuery = true)
    Page<Service> searchByName(@Param("key") String key, Pageable pageable);
}
