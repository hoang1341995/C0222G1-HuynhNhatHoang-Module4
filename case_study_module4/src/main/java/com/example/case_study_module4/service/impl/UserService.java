package com.example.case_study_module4.service.impl;

import com.example.case_study_module4.model.User;
import com.example.case_study_module4.repository.IUserRepository;
import com.example.case_study_module4.service.IUserService;
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
    public Optional<User> findByName(String name) {
        return iUserRepository.findById(name);
    }

    @Override
    public void update(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(String name) {
        iUserRepository.deleteById(name);
    }
}
