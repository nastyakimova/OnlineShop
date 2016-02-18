package com.github.nastyakimova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    private Customer customer;
    private Boolean isPaid;
    private List<Product> productList = new ArrayList<>();

    protected Order() {
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

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
        return orderID^(orderID>>>32);
    }

    @Override
    public String toString() {
        return "Order ¹" + orderID +
                ", customer=" + customer;
    }
}
