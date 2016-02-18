package com.github.nastyakimova.onlineshop.repositories;

import com.github.nastyakimova.onlineshop.entity.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}
