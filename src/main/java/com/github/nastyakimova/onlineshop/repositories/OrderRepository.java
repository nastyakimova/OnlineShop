package com.github.nastyakimova.onlineshop.repositories;

import com.github.nastyakimova.onlineshop.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
