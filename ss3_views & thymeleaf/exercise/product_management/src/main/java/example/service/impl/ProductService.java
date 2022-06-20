package example.service.impl;

import example.model.Product;
import example.repository.IProductRepository;
import example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(String id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        iProductRepository.update(id, product);
    }

    @Override
    public void remove(String id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return iProductRepository.searchByName(name);
    }
}
