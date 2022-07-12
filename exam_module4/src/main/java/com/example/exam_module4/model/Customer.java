package com.example.exam_module4.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^(KH-)[\\d]{4}$",message = "mã khách hàng sai định dạng. vd: KH-0123")
    @Column(unique = true)
    private String code;

    @NotBlank(message = "Tên không được trống")
    private String name;

    @NotBlank(message = "sinh nhật không được trống")
    @Column(name = "birth_day")
    private String birthDay;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Email không đúng định dạng")
    private String email;

    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$",message = "Số điện thoại không đúng định dạng")
    private String phone;

    @ManyToOne
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(Integer id, String code, String name, String birthDay, String email, String phone, CustomerType customerType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
