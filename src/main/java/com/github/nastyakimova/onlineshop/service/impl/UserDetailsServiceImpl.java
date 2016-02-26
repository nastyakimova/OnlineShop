package com.github.nastyakimova.onlineshop.service.impl;

import com.github.nastyakimova.onlineshop.entity.User;
import com.github.nastyakimova.onlineshop.entity.UserRole;
import com.github.nastyakimova.onlineshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        Set<GrantedAuthority> authorities = getAuthorities(user.getUserRole());
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        return (UserDetails) buildUserForAuthentication(user,encodedPassword,authorities);
    }

    private User buildUserForAuthentication(User user, String encodedPassword,Set <GrantedAuthority> authorities) {
        User authUser=new User();
        authUser.setUsername(user.getUsername());
        authUser.setPassword(encodedPassword);
        authUser.setUserRole(authorities);
        return authUser;
    }

    private Set<GrantedAuthority> getAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
            return setAuths;
        }
}
