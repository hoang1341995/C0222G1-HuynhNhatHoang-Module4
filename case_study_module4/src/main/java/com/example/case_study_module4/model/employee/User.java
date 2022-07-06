package com.example.case_study_module4.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user_table")
public class  User {

    @Id
    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    @JsonBackReference(value = "user")
    private Set<Employee> employees;

    public User() {
    }

    public User(String username, String password, Set<Employee> employees) {
        this.username = username;
        this.password = password;
        this.employees = employees;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
