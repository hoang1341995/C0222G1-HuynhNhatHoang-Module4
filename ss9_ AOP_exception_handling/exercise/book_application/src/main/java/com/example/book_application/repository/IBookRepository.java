package com.example.book_application.repository;


import com.example.book_application.model.Book;
import com.example.book_application.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBookRepository extends PagingAndSortingRepository<Book, Integer> {

    List<Book> findAll();

    @Query(value = "SELECT book_amount FROM book_model WHERE book_id = :id", nativeQuery = true)
    Integer getMountOfBook(@Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE book_model SET book_amount = :newAmount WHERE book_id = :id",
            nativeQuery = true)
    void borrow(@Param("id") Integer id,
                @Param("newAmount") Integer newAmount);

    @Query(value = "SELECT user_book_id FROM user WHERE user_code = :code", nativeQuery = true)
    Integer checkGiveBook(@Param("code") Integer code);

    @Modifying
    @Query(value = "DELETE FROM user WHERE user_code = :code", nativeQuery = true)
    void removeGiveBook(@Param("code") Integer code);


}
