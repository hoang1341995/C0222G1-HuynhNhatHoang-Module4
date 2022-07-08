package com.example.case_study_module4.service.contract.contract_impl;

import com.example.case_study_module4.model.contract.AttachService;
import com.example.case_study_module4.repository.contract.IAttachServiceRepository;
import com.example.case_study_module4.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
