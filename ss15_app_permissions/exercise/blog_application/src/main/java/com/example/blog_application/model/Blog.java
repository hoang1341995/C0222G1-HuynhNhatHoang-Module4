package com.example.blog_application.model;

import javax.persistence.*;

@Entity(name = "blog_table")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @Column(name = "posting_date")
    private String date;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String title, String content, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
