package com.example.exam_module4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "product_model")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Nhà sản xuất không được trống")
    private String name;
    @Min(value = 0,message = "Giá không được nhỏ hơn 0")
    @NotNull(message = "Vui lòng nhập giá")
    private Double price;
    @NotBlank(message = "Nhà sản xuất không được trống")
    private String producer;
    @NotBlank(message = "Mô tả không được trống")
    private String description;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String producer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
