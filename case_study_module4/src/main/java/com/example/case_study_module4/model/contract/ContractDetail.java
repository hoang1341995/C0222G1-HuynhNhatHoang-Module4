package com.example.case_study_module4.model.contract;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer contractDetailId;

    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AttachService  attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contract  contract;

    @Column
    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(AttachService attachService, Contract contract, Integer quantity) {
        this.attachService = attachService;
        this.contract = contract;
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}