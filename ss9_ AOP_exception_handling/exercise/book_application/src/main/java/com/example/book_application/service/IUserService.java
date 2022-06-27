package com.example.book_application.service;

import com.example.book_application.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    void save(User user);

    Optional<User> findById(Integer code);

    void remove(Integer code);

}
