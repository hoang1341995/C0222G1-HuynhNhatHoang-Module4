package example.repository.impl;

import example.model.Product;
import example.repository.BaseRepository;
import example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        List<Product> productLists = BaseRepository.entityManager.createQuery("select pm from product_model pm", Product.class).getResultList();
        return productLists;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        Product product = BaseRepository.entityManager.createQuery("select pm from product_model pm where pm.id = :id", Product.class).setParameter("id", id).getSingleResult();

        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listSearchByName = BaseRepository.entityManager.createQuery("select pm from product_model pm where pm.name like :name", Product.class).setParameter("name", "%" + name + "%").getResultList();
        return listSearchByName;
    }
}
