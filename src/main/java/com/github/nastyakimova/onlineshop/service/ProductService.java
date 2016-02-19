package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);

    Product getProductById(int productID);

    void deleteProduct(Product product);

    void updateProduct(Product product);

    List<Product> getAllProducts();
}
