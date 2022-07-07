package com.example.case_study_module4.service.impl.service_impl;

import com.example.case_study_module4.model.service.Service;
import com.example.case_study_module4.repository.service.IServiceRepository;
import com.example.case_study_module4.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }
    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public Optional<Service> findById(Integer id) {
        return iServiceRepository.findById(id);
    }

    @Override
    public void update(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Page<Service> searchByName(String key, Pageable pageable) {
        return iServiceRepository.searchByName("%" + key + "%", pageable);
    }
}
