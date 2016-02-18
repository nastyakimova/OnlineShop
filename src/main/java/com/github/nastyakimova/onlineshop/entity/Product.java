package com.github.nastyakimova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    private String title;
    private Boolean isAvailable;
    private BigDecimal price;

    public Integer getProductID() {
        return productID;
    }

    protected Product() {
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return product.productID == productID;

    }

    @Override
    public int hashCode() {
        return productID ^ (productID >>> 32);
    }

    @Override
    public String toString() {
        return "Product: " + title + "(" + price + "$ )";
    }

}
