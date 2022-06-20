package example.repository.impl;

import example.model.Product;
import example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("IP11", "Iphone 11", 1000, "apple", "new 100%"));
        productList.add(new Product("IP12", "Iphone 12", 1200, "apple", "new 100%"));
        productList.add(new Product("IP13", "Iphone 13", 1500, "apple", "new 100%"));
        productList.add(new Product("SS20", "samsung note 20", 1500, "samsung", "new 100%"));
        productList.add(new Product("SS10", "samsung note 10", 1200, "samsung", "new 100%"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(String id) {
        for (Product products : productList) {
            if (products.getId().equals(id)) {
                return products;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setProducer(product.getProducer());
                productList.get(i).setDescription(product.getDescription());
            }
        }
    }

    @Override
    public void remove(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.remove(i);
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listSearchByName = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                listSearchByName.add(productList.get(i));
            }
        }
        return listSearchByName;
    }
}
