package com.example.case_study_module4.model.contract;

import com.example.case_study_module4.model.customer.Customer;
import com.example.case_study_module4.model.employee.Employee;
import com.example.case_study_module4.model.service.Service;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_start_date")
    private String startDate;

    @Column(name = "contract_end_date")
    private String endDate;

    @Column(name = "contract_deposit")
    private String deposit;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Service service;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference(value = "contract")
    private Set<ContractDetail> contractDetailList;

    public Integer getContractId() {
        return contractId;
    }

    public Contract() {
    }

    public Contract(Integer contractId,
                    String startDate,
                    String endDate,
                    String deposit,
                    Employee employee,
                    Customer customer,
                    Service service) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(Set<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
