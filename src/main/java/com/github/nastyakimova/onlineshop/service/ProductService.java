package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);

    Product getProductById(Integer productID);

    void deleteProduct(Product product);


    List<Product> getAllProducts();

    List<Product> getProductPage(int pageNumber, int pageSize);

}
