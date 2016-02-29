package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.User;
import com.github.nastyakimova.onlineshop.repositories.UserRepository;
import com.github.nastyakimova.onlineshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
        LOG.info(user + " was saved to the database");

    }
}
