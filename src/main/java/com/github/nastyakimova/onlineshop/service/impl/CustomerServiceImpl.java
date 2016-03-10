package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.repositories.CustomerRepository;
import com.github.nastyakimova.onlineshop.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    public static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
        LOG.info(customer + " successfully saved to database");
    }

    @Override
    public Customer getCustomerById(Integer customerID) {
        Customer customer = customerRepository.findOne(customerID);
        LOG.info(customer + " was loaded from the database");
        return customer;
    }

    @Override
    public void lockCustomer(Customer customer) {
        if (!customer.getIsLocked()) {
            customer.setIsLocked(true);
            customerRepository.save(customer);
            LOG.info(customer + " was locked");
        } else {
            unlockCustomer(customer);
        }
    }

    @Override
    public void unlockCustomer(Customer customer) {
            customer.setIsLocked(false);
            customerRepository.save(customer);
            LOG.info(customer + " was unlocked");
    }

    @Override
    public List<Customer> getAllCustomers() {
        Iterable<Customer> customerList = customerRepository.findAll();
        LOG.info("list of all customers was loaded from the database");
        return newArrayList(customerList);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        LOG.info(customer + " was loaded from the database");
        return customer;
    }
}
