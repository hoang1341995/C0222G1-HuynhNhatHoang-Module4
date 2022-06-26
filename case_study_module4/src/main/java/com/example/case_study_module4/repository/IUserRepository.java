package com.example.case_study_module4.repository;

import com.example.case_study_module4.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User, String> {
}
