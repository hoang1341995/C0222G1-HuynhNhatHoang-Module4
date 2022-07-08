package com.example.case_study_module4.repository.contract;

import com.example.case_study_module4.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(value = "SELECT * FROM contract_detail WHERE contract_id = :id", nativeQuery = true)
    List<ContractDetail> findByIdContract(@Param("id") Integer id);

//    @Query(value =
//            "select *, sum(quantity) as quantity from contract_detail cd " +
//                    " join attach_service ass on ass.attach_service_id = cd.attach_service_id " +
//                    " join contract ct on ct.contract_id = cd.contract_id " +
//                    " where ct.contract_id = :id " +
//                    " group by cd.attach_service_id"
//            , nativeQuery = true)
//    List<ContractDetail> findByIdContract(@Param("id") Integer id);



}
