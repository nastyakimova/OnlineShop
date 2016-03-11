package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * Saves product or update if it has already exists.
     *
     * @param product Product object which is going to be created or updated.
     */
    void saveProduct(Product product);

    /**
     * Returns product with given id.
     *
     * @param productID Id of a product.
     * @return Product object.
     */
    Product getProductById(Integer productID);

    /**
     * Deletes product.
     *
     * @param product Product object which is going to be deleted.
     */
    void deleteProduct(Product product);


    /**
     * Returns list of all saved products.
     *
     * @return List of products.
     */
    List<Product> getAllProducts();


    /**
     * Loads list of given number of products for given page.
     * Method for pagination.
     *
     * @param pageNumber number of page where is going to be shown list of products.
     * @param pageSize   number of products at a page.
     * @return List of products.
     */
    List<Product> getProductPage(int pageNumber, int pageSize);


    /**
     * Counts all saved products.
     *
     * @return number of products.
     */
    long getAmountPage();
}
