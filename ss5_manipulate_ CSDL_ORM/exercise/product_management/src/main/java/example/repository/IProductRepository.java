package example.repository;

import example.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);

    void remove(Product product);

    List<Product> searchByName(String name);

}
