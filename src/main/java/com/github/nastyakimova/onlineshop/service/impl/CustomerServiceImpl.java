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
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        LOG.info(customer + " was deleted from the database");

    }

    @Override
    public void lockCustomer(Customer customer) {
        customer.setIsLocked(true);
        customerRepository.save(customer);
        LOG.info(customer + " was locked");
    }

    @Override
    public void unlockCustomer(Customer customer) {
        if (customer.getIsLocked()) {
            customer.setIsLocked(false);
            customerRepository.save(customer);
            LOG.info(customer + " was unlocked");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        LOG.info("list of all customers was loaded from the database");
        return customerList;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer=customerRepository.findByEmail(email);
        LOG.info(customer+" was loaded from the database");
        return customer;
    }
}
