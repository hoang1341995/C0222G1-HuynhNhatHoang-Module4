package com.example.case_study_module4.repository;

import com.example.case_study_module4.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IUserRepository extends PagingAndSortingRepository<User, String> {

    List<User> findAll();
}
