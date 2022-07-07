package com.example.case_study_module4.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "rent_type_table")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer id;

    @Column(name = "rent_type_name")
    private String name;

    @Column(name = "rent_type_cost")
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    @JsonBackReference(value = "rentType")
    private Set<Service> serviceList;

    public RentType() {
    }

    public RentType(Integer id, String name, Double rentTypeCost, Set<Service> serviceList) {
        this.id = id;
        this.name = name;
        this.rentTypeCost = rentTypeCost;
        this.serviceList = serviceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Set<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
