package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * Update customer if he has already exists in database.
     * Otherwise creates new Customer object
     *
     * @param customer Customer object which is going to be created
     */
    void saveCustomer(Customer customer);

    /**
     * Gets customer by its id.
     * @param customerID ID of a chosen customer
     * @return Customer object
     */
    Customer getCustomerById(Integer customerID);

    /**
     * Blocks customer by admin.
     * Sets customer`s flag isLocked to value True.
     * @param customer customer to be locked
     */
    void lockCustomer(Customer customer);

    /**
     * Unblock customer by admin.
     * Sets customer`s flag isLocked to value False.
     * @param customer customer to be unlocked
     */
    void unlockCustomer(Customer customer);

    /**
     * Returns list of all customers stored in database
     * @return List of Customer object
     */
    List<Customer> getAllCustomers();

    /**
     * Returns customer with given email/
     * @param email email of a customer
     * @return Customer object with given email
     */
    Customer getCustomerByEmail(String email);

}
