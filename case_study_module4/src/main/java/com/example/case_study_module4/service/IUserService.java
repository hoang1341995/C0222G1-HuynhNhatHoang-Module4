package com.example.case_study_module4.service;

import com.example.case_study_module4.model.Customer;
import com.example.case_study_module4.model.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findByName(String name);

    void update(User user);

    void remove(String name);

}
