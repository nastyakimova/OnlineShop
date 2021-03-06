package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.Product;
import com.github.nastyakimova.onlineshop.repositories.ProductRepository;
import com.github.nastyakimova.onlineshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    public static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
        LOG.info(product + " was saved to the database");
    }

    @Override
    public Product getProductById(Integer productID) {
        Product product = productRepository.findOne(productID);
        LOG.info(product + " was loaded from the database");
        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
        LOG.info(product + " was deleted from the database");
    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<Product> productList = productRepository.findAll();
        LOG.info("list of all products was loaded from the database");
        return newArrayList(productList);
    }

    @Override
    public List<Product> getProductPage(int pageNumber, int pageSize) {
        Iterable<Product> allProducts = productRepository.findAll(new PageRequest(pageNumber, pageSize));
        LOG.info("Page number " + pageNumber + " page size " + pageSize);
        return newArrayList(allProducts);
    }

    @Override
    public long getAmountPage() {
        return productRepository.countProducts();
    }

}
