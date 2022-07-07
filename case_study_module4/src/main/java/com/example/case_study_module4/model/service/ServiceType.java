package com.example.case_study_module4.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "service_type_table")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer id;

    @Column(name = "service_type_name")
    private String name;

    @OneToMany(mappedBy = "serviceType")
    @JsonBackReference(value = "serviceType")
    private Set<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(Integer id, String name, Set<Service> serviceList) {
        this.id = id;
        this.name = name;
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

    public Set<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Set<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
