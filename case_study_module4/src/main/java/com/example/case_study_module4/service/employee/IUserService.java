package com.example.case_study_module4.service.employee;

import com.example.case_study_module4.model.employee.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    Optional<User> findByName(String name);

    void update(User user);

    void save(User user);

    void remove(String name);

}
