package com.github.nastyakimova.onlineshop.service.entity;

import com.github.nastyakimova.onlineshop.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    Map<Product, Integer> productCart;


    public ShoppingCart() {
        productCart = new HashMap<>();
    }

    public Map<Product, Integer> getProductCart() {
        return productCart;
    }

    public void addProduct(Product product) {
        if (!productCart.containsKey(product)) {
            productCart.put(product, 1);
        } else {
            productCart.put(product, productCart.get(product) + 1);
        }
    }

    public void deleteProduct(Product product) {
        if (productCart.get(product) == 1) {
            productCart.remove(product);
        } else {
            productCart.put(product, productCart.get(product) - 1);
        }
    }
    public void emptyCart(){
        productCart.clear();
    }
}