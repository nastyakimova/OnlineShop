package com.github.nastyakimova.onlineshop.repositories;

import com.github.nastyakimova.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    @Query("select count(product.productID) from Product product ")
    long countProducts();
}

