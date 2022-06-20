package example.service;

import example.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(String id);

    void update(String id, Product product);

    void remove(String id);

    List<Product> searchByName(String name);

}
