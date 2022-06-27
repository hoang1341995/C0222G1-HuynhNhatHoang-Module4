package com.example.book_application.service.impl;

import com.example.book_application.model.User;
import com.example.book_application.repository.IUserRepository;
import com.example.book_application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer code) {
        return iUserRepository.findById(code);
    }

    @Override
    public void remove(Integer code) {
        iUserRepository.deleteById(code);
    }
}
