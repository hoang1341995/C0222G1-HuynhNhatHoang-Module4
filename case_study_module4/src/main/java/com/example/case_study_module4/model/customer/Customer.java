package com.example.case_study_module4.model.customer;

import com.example.case_study_module4.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_birthday")
    private String birthday;

    @Column(name = "customer_id_card")
    private String idCard;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_code")
    private String code;

    @Column(name = "customer_gender")
    private Integer gender;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractList;

    public Customer() {
    }

    public Customer(Integer id,
                    String name,
                    String birthday,
                    String idCard,
                    String phone,
                    String email,
                    String address,
                    String code,
                    Integer gender,
                    CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.code = code;
        this.gender = gender;
        this.customerType = customerType;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
