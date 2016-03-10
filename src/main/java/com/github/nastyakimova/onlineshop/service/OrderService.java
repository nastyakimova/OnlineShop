package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.entity.Product;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getAllOrders();

    void createOrder(Customer customer,Map<Product,Integer> productCart);

}
