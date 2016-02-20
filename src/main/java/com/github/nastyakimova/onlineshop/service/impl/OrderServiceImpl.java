package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.entity.Product;
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
    public static final Logger LOG = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
        LOG.info(order + " was saved to the database");
    }

    @Override
    public Order getOrderById(Integer orderID) {
        Order order = orderRepository.findOne(orderID);
        LOG.info(order + " was loaded from the database");
        return order;
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
        LOG.info(order + " was deleted from the database");
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = (List<Order>) orderRepository.findAll();
        LOG.info("list of all orders was loaded from the database");
        return orderList;
    }

    @Override
    public List<Order> getAllOrdersInCart(Customer customer) {
        return null;
    }

    @Override
    public void addProductsToOrder(Order order, List<Product> productList) {
        for (Product product : productList) {
            order.getProductList().add(product);
            LOG.info(product + " was added successfully to the order " + order);
        }
        orderRepository.save(order);
    }
}
