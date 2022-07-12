package com.example.exam_module4.service;

import com.example.exam_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(Integer id);

    Page<Product> searchByName(String name,Pageable pageable);

}
