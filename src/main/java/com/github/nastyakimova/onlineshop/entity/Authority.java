package com.github.nastyakimova.onlineshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    private String username;
    private String authority;

    public Authority() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username",nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name = "authority",nullable = false,length = 50)
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
