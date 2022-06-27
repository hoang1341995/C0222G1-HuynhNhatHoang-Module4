package com.example.book_application.service.impl;

import com.example.book_application.model.Book;
import com.example.book_application.model.User;
import com.example.book_application.repository.IBookRepository;
import com.example.book_application.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements IBookService {


    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void update(Integer id) {
        Integer newAmount = iBookRepository.getMountOfBook(id) - 1;
        iBookRepository.borrow(id,newAmount);
    }

    @Override
    public boolean giveBack(Integer bookId,Integer code) {
       Integer user_book_id = iBookRepository.checkGiveBook(code);
        if (user_book_id != null){
            if (user_book_id == bookId){
                iBookRepository.removeGiveBook(code);
                Integer newAmount = iBookRepository.getMountOfBook(bookId) + 1;
                iBookRepository.borrow(bookId,newAmount);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Book> findById(int id) {
        return iBookRepository.findById(id);
    }
}
