package com.example.case_study_module4.service.contract;

import com.example.case_study_module4.model.contract.Contract;
import com.example.case_study_module4.model.dto.contract_dto.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    Page<ContractDto> findAll(Pageable pageable);

    List<ContractDto> findAllList(Pageable pageable);

    void save(Contract contract);

    void delete(Contract contract);

    Contract findById(Integer id);

}
