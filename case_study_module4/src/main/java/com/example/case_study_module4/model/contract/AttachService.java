package com.example.case_study_module4.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;

    @Column(name = "attach_service_name")
    private String attachServiceName;

    @Column(name = "attach_service_cost")
    private Double attachServiceCost;

    @Column(name = "attach_service_unit")
    private String attachServiceUnit;

    @Column(name = "attach_service_status")
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    @JsonBackReference(value = "attachService")
    private Set<ContractDetail> contractDetailList;

    public AttachService() {
    }

    public AttachService(Integer attachServiceId, String attachServiceName, Double attachServiceCost, String attachServiceUnit, String attachServiceStatus, Set<ContractDetail> contractDetailList) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetailList = contractDetailList;
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(Set<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}