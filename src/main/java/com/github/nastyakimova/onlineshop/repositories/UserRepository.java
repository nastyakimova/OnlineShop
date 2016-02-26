package com.github.nastyakimova.onlineshop.repositories;

import com.github.nastyakimova.onlineshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
