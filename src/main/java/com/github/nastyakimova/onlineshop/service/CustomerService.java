package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);

    Customer getCustomerById(int customerID);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

}
