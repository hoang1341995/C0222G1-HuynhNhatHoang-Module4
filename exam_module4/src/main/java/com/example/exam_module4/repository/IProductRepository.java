package com.example.exam_module4.repository;

import com.example.exam_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product_model",nativeQuery = true)
    Page<Product> findAll(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO product_model (name, price, producer, description) VALUES (:name, :price, :producer, :description)",
            nativeQuery = true)
    void save(@Param("name") String name,
              @Param("price") Double price,
              @Param("producer") String producer,
              @Param("description") String description);

    @Query(value = "SELECT * FROM product_model WHERE id = :id", nativeQuery = true)
    Product findById(@Param("id") int id);

    @Modifying
    @Query(value = "UPDATE product_model SET name = :name, price = :price, producer = :producer, description = :description WHERE id = :id",
            nativeQuery = true)
    void update(@Param("name") String name,
                @Param("price") Double price,
                @Param("producer") String producer,
                @Param("description") String description,
                @Param("id") int id);

    @Query(value = "SELECT * FROM product_model WHERE name LIKE :name", nativeQuery = true)
    Page<Product> searchByName(@Param("name") String name,Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM product_model WHERE id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

}
