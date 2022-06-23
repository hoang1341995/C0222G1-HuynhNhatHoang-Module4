package com.example.product_plus.service.impl;

import com.example.product_plus.model.Product;
import com.example.product_plus.repository.IProductRepository;
import com.example.product_plus.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product.getName(),product.getPrice(),product.getProducer(),product.getDescription());
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product.getName(),product.getPrice(),product.getProducer(),product.getDescription(),product.getId());
    }

    @Override
    public void remove(Integer id) {
        iProductRepository.remove(id);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return iProductRepository.searchByName("%" + name + "%",pageable);
    }
}
