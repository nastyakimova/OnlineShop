package com.github.nastyakimova.onlineshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private Integer orderID;
    private Customer customer;
    private List<Product> productList = new ArrayList<>();

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id", unique = true, nullable = false)
    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return order.orderID == orderID;
    }

    @Override
    public int hashCode() {
        return orderID ^ (orderID >>> 32);
    }

    @Override
    public String toString() {
        return "Order " + orderID +
                ", customer=" + customer;
    }
}
