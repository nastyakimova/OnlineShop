package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.repositories.CustomerRepository;
import com.github.nastyakimova.onlineshop.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    public static final Logger LOG = Logger.getLogger(CustomerServiceImpl.class);
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
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        LOG.info(customer + " was deleted from the database");

    }

    @Override
    public void lockCustomer(Customer customer) {

    }

    @Override
    public void unlockCustomer(Customer customer) {

    }
}
