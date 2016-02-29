package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.Authority;
import com.github.nastyakimova.onlineshop.repositories.AuthorityRepository;
import com.github.nastyakimova.onlineshop.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    public static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);


    @Override
    public void saveAuthority(Authority authority) {
        authorityRepository.save(authority);
        LOG.info(authority + " was saved to the database");

    }
}
