package com.example.case_study_module4.service.service;

import com.example.case_study_module4.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {

    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();

    void save(Service service);

    Optional<Service> findById(Integer id);

    void update(Service service);

    void remove(Integer id);

    Page<Service> searchByName(String key,Pageable pageable);

}
