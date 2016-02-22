package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);

    Customer getCustomerById(Integer customerID);

    void deleteCustomer(Customer customer);

    void lockCustomer(Customer customer);

    void unlockCustomer(Customer customer);

    List<Customer> getAllCustomers();

}
