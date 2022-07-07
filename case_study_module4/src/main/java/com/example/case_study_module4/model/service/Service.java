package com.example.case_study_module4.model.service;

import javax.persistence.*;

@Entity(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service_code")
    private String code;

    @Column(name = "service_name")
    private String name;

    @Column(name = "service_cost")
    private Double serviceCost;

    @Column(name = "service_area")
    private Double area;

    @Column(name = "service_max_people")
    private Integer maxPeople ;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")  //model
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")  //model
    private ServiceType serviceType;

    @Column(name = "standard_room")
    private String standardRoom;

    @Column(name = "description_other_convenience")
    private String description;

    @Column(name = "pool_area")
    private Double poolArea = 0.0d;

    @Column(name = "number_of_floors")
    private Integer floor = 0;

    public Service() {
    }

    public Service(Integer id, String code, String name, Double serviceCost,
                   Double area, Integer maxPeople, RentType rentType,
                   ServiceType serviceType, String standardRoom, String description,
                   Double poolArea, Integer floor) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.serviceCost = serviceCost;
        this.area = area;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
