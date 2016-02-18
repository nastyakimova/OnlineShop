package com.github.nastyakimova.onlineshop.repositories;

import com.github.nastyakimova.onlineshop.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
