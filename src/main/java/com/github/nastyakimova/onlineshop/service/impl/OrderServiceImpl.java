package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.entity.Product;
import com.github.nastyakimova.onlineshop.repositories.CustomerRepository;
import com.github.nastyakimova.onlineshop.repositories.OrderRepository;
import com.github.nastyakimova.onlineshop.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    public static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;

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
        Iterable<Order> orderList = orderRepository.findAll();
        LOG.info("list of all orders was loaded from the database");
        return newArrayList(orderList);
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

    @Override
    public void createOrder(Customer customer, List<Product> productList) {
        if (!customer.getIsLocked()) {
            Order order = new Order();
            order.setProductList(productList);
            LOG.info("products were added to the order " + order);
            order.setCustomer(customer);
            orderRepository.save(order);
            LOG.info("was create order " + order + " for customer " + customer);
        }
    }
}
