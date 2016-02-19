package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);

    Order getOrderById();

    void deleteOrder(Order order);

    void updateOrder(Order order);

    List<Order> getAllOrders();

    List<Order> getAllOrdersInCart(Customer customer);

}
