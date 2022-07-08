package com.example.case_study_module4.model.dto.contract_dto;

import com.example.case_study_module4.model.customer.Customer;
import com.example.case_study_module4.model.employee.Employee;
import com.example.case_study_module4.model.service.Service;

public class ContractDto {

    private Integer contractId;

    private String startDate;

    private String endDate;

    private String deposit;

    private Employee employee;

    private Customer customer;

    private Service service;

    private Double totalCost;

    public ContractDto() {
    }

    public ContractDto(Integer contractId, String startDate, String endDate, String deposit, Employee employee, Customer customer, Service service, Double totalCost) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.totalCost = totalCost;
    }

    public Integer getContractId() {
        return contractId;
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

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
