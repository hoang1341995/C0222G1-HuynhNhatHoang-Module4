package com.example.book_application.model;

import javax.persistence.*;

@Entity(name = "user")
public class User {
    @Id
    @Column(name = "user_code")
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "user_book_id")
    private Book book;

    public User() {
    }

    public User(Integer code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
