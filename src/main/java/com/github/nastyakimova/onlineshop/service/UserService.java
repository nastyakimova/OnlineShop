package com.github.nastyakimova.onlineshop.service;

import com.github.nastyakimova.onlineshop.entity.User;

public interface UserService {

    /**
     * Saves user.
     *
     * @param user User object which is going to be created.
     */
    void saveUser(User user);
}
