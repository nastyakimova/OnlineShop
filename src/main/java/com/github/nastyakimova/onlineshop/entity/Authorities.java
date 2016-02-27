package com.github.nastyakimova.onlineshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {
    private User user;
    private String authority;

    public Authorities() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username",nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Column(name = "authority",nullable = false,length = 50)
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
