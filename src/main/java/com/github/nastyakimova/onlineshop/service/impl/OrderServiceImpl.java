package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.repositories.OrderRepository;
import com.github.nastyakimova.onlineshop.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    public static final Logger LOG= Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {

    }

    @Override
    public Order getOrderById(Integer orderID) {
        return null;
    }

    @Override
    public void deleteOrder(Order order) {

    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getAllOrdersInCart(Customer customer) {
        return null;
    }
}
