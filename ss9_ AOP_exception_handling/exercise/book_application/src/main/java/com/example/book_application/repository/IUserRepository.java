package com.example.book_application.repository;


import com.example.book_application.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IUserRepository  extends PagingAndSortingRepository<User, Integer> {

    List<User> findAll();
}
