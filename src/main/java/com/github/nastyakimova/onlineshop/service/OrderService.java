package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.entity.Product;

import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * Returns list of all saved orders.
     *
     * @return List of all orders.
     */
    List<Order> getAllOrders();

    /**
     * Creates new order for given customer.
     * Adds to this order all items, which were chosen and added to customer`s product cart.
     *
     * @param customer    Customer who make an order.
     * @param productCart Map which stores all chosen products and their quantity.
     */
    void createOrder(Customer customer, Map<Product, Integer> productCart);

}
