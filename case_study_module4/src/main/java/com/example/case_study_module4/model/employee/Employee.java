package com.example.case_study_module4.model.employee;

import javax.persistence.*;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_birthday")
    private String birthday;

    @Column(name = "employee_id_card")
    private String idCard;

    @Column(name = "employee_phone")
    private String phone;

    @Column(name = "employee_email")
    private String email;

    @Column(name = "employee_address")
    private String address;

    @Column(name = "employee_salary")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "employee_position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "employee_education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "employee_division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Employee() {
    }

    public Employee(Integer id, String name, String birthday, String idCard,
                    String phone, String email, String address, Double salary,
                    Position position, Education education, Division division,
                    User user) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.position = position;
        this.education = education;
        this.division = division;
        this.user = user;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUsers(User users) {
        this.user = user;
    }
}
