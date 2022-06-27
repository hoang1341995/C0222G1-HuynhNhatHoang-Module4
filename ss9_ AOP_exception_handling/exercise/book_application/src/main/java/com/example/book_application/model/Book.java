package com.example.book_application.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book_model")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "book_code")
    private String code;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_publication_date")
    private String publicationDate;

    @Column(name = "book_amount")
    private Integer amount;

    @OneToMany(mappedBy = "book")
    private Set<User> users;

    public Book() {
    }

    public Book(Integer id, String code, String name, String author,
                String publicationDate, Integer amount, Set<User> users) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.amount = amount;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
