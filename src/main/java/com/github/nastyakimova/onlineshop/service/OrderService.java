package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.entity.Product;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);

    Order getOrderById(Integer orderID);

    void deleteOrder(Order order);

    List<Order> getAllOrders();

    List<Order> getAllOrdersInCart(Customer customer);

    void addProductsToOrder(Order order, List<Product> productList);
    void createOrder(Customer customer,Order order,List<Product> productList);

}
