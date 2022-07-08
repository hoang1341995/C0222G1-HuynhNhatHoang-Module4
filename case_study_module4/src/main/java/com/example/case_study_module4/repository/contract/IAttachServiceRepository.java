package com.example.case_study_module4.repository.contract;

import com.example.case_study_module4.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {
}
