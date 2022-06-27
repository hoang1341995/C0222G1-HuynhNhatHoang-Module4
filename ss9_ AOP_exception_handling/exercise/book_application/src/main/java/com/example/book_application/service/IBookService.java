package com.example.book_application.service;

import com.example.book_application.model.Book;
import com.example.book_application.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IBookService {

    List<Book> findAll();

     void update(Integer id);

    boolean giveBack(Integer bookId,Integer code);

    Optional<Book> findById(int id);

}
