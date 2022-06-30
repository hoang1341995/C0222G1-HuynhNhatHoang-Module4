package com.example.shopping_cart.repository;


import com.example.shopping_cart.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Modifying
    @Query(value = "UPDATE product SET book_amount = :newAmount WHERE book_id = :id",
            nativeQuery = true)
    void borrow(@Param("id") Integer id,
                @Param("newAmount") Integer newAmount);
}
