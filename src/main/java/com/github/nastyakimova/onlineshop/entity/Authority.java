package com.github.nastyakimova.onlineshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    private Integer id;
    private User user;
    private String authority;

    public Authority(User user, String authority) {
        this.user = user;
        this.authority = authority;
    }

    public Authority() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "username")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
