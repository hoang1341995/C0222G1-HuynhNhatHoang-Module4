package com.example.case_study_module4.service.contract.contract_impl;

import com.example.case_study_module4.model.contract.ContractDetail;
import com.example.case_study_module4.repository.contract.IContractDetailRepository;
import com.example.case_study_module4.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findByIdContract(Integer id) {
        return iContractDetailRepository.findByIdContract(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
