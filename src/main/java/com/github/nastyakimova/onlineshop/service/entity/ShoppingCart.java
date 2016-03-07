package com.github.nastyakimova.onlineshop.service.entity;

import com.github.nastyakimova.onlineshop.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProduct(Product product) {
        productList.remove(product);
    }

    public void removeAllProducts() {productList.clear();}
}